package tn.esprit.spring.service;

import tn.esprit.spring.entity.User;

import java.util.List;

public interface IUserService {
	public String BannedUser(long id);

	public void add(User u);

	public List<User> getAll();

	public void initialize();


	public void update(User u);


	
	

}
