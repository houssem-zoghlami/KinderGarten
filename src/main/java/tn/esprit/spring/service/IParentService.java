package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Parent;

public interface IParentService {

	public void addParent(Parent parent);

	public void deleteParent(int id);

	public Parent updateParent(int id, Parent parent);

	public Parent retrieveParent(int id);
	
	public List<Parent> retrieveAllParents();
	
	public List<Parent> getAllParentByEvent(@Param("event") Event event);
	
	public List<Parent> getAllParentByAddress(@Param("address") String address);
	
	public List<Parent> getAllParentByLastName(@Param("lastName") String lastName);
	
	public List<Parent> getAllParentByFirstName(@Param("firstName") String firstName);
	
	public Parent retrieveParentByPhone(@Param("phone") int phone);
}
