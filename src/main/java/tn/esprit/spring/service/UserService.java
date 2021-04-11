package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.UserC;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserC addUser(UserC user){
		return userRepository.save(user);
	}
	
	
	public UserC findByUserName(String userName) {
		UserC user = userRepository.findByUserName(userName);
		return user;
	}

}
