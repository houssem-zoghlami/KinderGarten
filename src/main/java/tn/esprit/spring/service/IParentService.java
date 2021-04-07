package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Parent;

public interface IParentService {

	public void addParent(Parent parent);

	public void deleteParent(int id);

	public Parent updateParent(int id, Parent parent);

	public Parent retrieveParent(int id);

	public List<Parent> retrieveAllParents();

	public List<Parent> getAllParentByEvent(Event event);

	public List<Parent> getAllParentByAddress(String address);

	public List<Parent> getAllParentByLastName(String lastName);

	public List<Parent> getAllParentByFirstName(String firstName);

	public Parent retrieveParentByPhone(int phone);

	public int participateParentInEvent(int idParent, int idEvent);

	public int unparticipateParentInEvent(int idParent, int idEvent);
	
	public int joinKindergarten(int idParent, int idKindergarten, int month, int idChild);

	

}
