package tn.esprit.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
	
	
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	MailService servicemail;

	@Autowired
	UserRepository userR;


	@Override
	public void add(User u) {

	}

	@Override
	public List<User> getAll() {

		return (List<User>) userR.findAll();
	}

	@Override
	public void initialize() {

	}

	@Override
	public void delete(int id) {

	}




	@Override
	public User findByEmail(String email) {

		return null;
	}

	@Override
	public void ChangeStateUser(int id) {

	}

	@Override
	public void blockAccount(int id) {

	}

	@Override
	public void confirmerInscriptionParMail(User u) {

	}

	@Override
	public String RegisterKinderGarten(int iduser, int id_kg) {
		return null;
	}

	@Override
	public void sendMailAlertToResponsibleKinderGarten(int id) {

	}

	@Override
	public void update(User u) {

		String pwd = new BCryptPasswordEncoder().encode(u.getPassword());

		u.setPassword(pwd);
		userR.save(u);
	}

	@Override
	public void changePassWord(long id, String pwd) {

		User u = userR.findById(id).get();

		if (u != null) {

			u.setPassword(pwd);

			this.update(u);
		}

	}



}
