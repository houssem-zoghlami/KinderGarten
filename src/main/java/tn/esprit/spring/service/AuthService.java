package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.dto.*;
import tn.esprit.spring.entity.NotificationEmail;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;
import tn.esprit.spring.exceptions.SpringForumException;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VerificationTokenRepository;
import tn.esprit.spring.security.JwtProvider;
import tn.esprit.spring.sms.SmsRequest;
import tn.esprit.spring.sms.TwilioConfiguration;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;
    private final tn.esprit.spring.sms.Service smsSender;
    private final TwilioConfiguration twilioConfiguration;



    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);
        user.setPhoneNumber(registerRequest.getPhoneNumber());

        userRepository.save(user);
        String phonenumber =user.getPhoneNumber();

        String token = generateVerificationToken(user);
//        smsSender.sendSms(new SmsRequest("+21621866406","amin ya m3allem " +
//                "please click on the below url to activate your account: " +
//                "http://localhost:8081/api/auth/accountVerification/" + token));


//        mailService.sendMail(new NotificationEmail("Please Activate your Account.", user.getEmail(),
//                "Thank you for signing up to our Forum, " +
//                        "please click on the below url to activate your account : " +
//                        "http://localhost:8081/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new SpringForumException("Invalid token"));
        fetchUserAndEnable(verificationToken.get());

    }


    @Transactional
    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new SpringForumException("User not found with name - " + username));
        user.setEnabled(true);

        userRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);

        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getUsername())
                .build();
    }

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();

        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());

        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(refreshTokenRequest.getUsername())
                .build();
    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
    public void changepwd(ResetPassword resetPassword) {
        User user = getCurrentUser();
        user.setPassword(passwordEncoder.encode(resetPassword.getPassword()));

        userRepository.save(user);
        smsSender.sendSms(new SmsRequest("","password reset successful: thank you" + "" +
                "your new password is "+ passwordEncoder.upgradeEncoding(user.getPassword())));

        mailService.sendMail(new NotificationEmail("Reset password .", user.getEmail(),
                        " password reset successful: thank you "
                         + user.getUsername()));
    }
//    public void changepwdnonloggedinuser(RegisterRequest registerRequest) {
//
//    }
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//
//        userRepository.save(user);
//
//        String token = generateVerificationToken(user);
//        mailService.sendMail(new NotificationEmail("Please Activate your Account.", user.getEmail(),
//                "Thank you for signing up to our Forum, " +
//                        "please click on the below url to activate your account : " +
//                        "http://localhost:8081/api/auth/accountVerification/" + token));
    }










