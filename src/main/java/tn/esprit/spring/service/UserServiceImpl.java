package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.NotificationEmail;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {


	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	MailService servicemail;

	@Autowired
	UserRepository userRepository;

	private final MailService mailService;


	@Override
	public void add(User u) {

	}

	@Override
	public List<User> getAll() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public void initialize() {
		User user1 = new User();
		user1.setEmail("testadmin@user.com");
		user1.setUsername("Test User admin");
		user1.setPhoneNumber("21866406");
		user1.setRole(Role.Admin);
		user1.setEnabled(true);
		user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
		this.add(user1);


	}


	@Override
	public String BannedUser(long id) {
		User u = userRepository.findById(id).orElse(null);
		if (u.isEnabled() == true) {
			userRepository.BannedUser(id);
			userRepository.save(u);
			mailService.sendMail(new NotificationEmail("KinderGarten Administrator .", u.getEmail(),
					"your account is banned  " + "please contact us for more details "));

		}
		return "user banned";
	}






	@Override
	public void update(User u) {

		String pwd = new BCryptPasswordEncoder().encode(u.getPassword());

		u.setPassword(pwd);
		userRepository.save(u);
	}

}
