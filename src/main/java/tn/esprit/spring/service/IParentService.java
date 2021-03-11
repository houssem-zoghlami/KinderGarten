package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Parent;

public interface IParentService {

	public void addParent(Parent parent);

	public void deleteParent(int id);

	public void updateParent(int id, String firstName, String lastName, int phone);

	public Parent retrieveParent(int id);
	
	public List<Parent> retrieveAllParents();
}
