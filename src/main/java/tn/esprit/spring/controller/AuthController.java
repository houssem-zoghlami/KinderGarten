package tn.esprit.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.dto.AuthenticationResponse;
import tn.esprit.spring.dto.LoginRequest;
import tn.esprit.spring.dto.RefreshTokenRequest;
import tn.esprit.spring.dto.RegisterRequest;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.AuthService;
import tn.esprit.spring.service.RefreshTokenService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    @Autowired
    UserRepository userRepository;



    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest resisterRequest) {
        authService.signup(resisterRequest);
        return new ResponseEntity<>("User Registration Successful!", HttpStatus.OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);

    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }
    //change password for the current user
    @PutMapping("/changepwd")
    public ResponseEntity<String> changepwd(@RequestBody RegisterRequest resisterRequest) {
        authService.changepwd(resisterRequest);
        return new ResponseEntity<>("password reset successful!", HttpStatus.OK);
    }
//change password for non logged in user


}
