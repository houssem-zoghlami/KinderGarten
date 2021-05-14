package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Parent;

public interface IChildService {

	public void addChild(Child child, int parentid);

	public void deleteChild(int id);

	public Child updateChild(int id, Child child);

	public Child retrieveChild(int id);

	public List<Child> retrieveAllChild();
	
	public List<Parent> getAllParentOfChildNoSubscribe();
	
	public List<Parent> getAllParent(int id);
	
	public List<Child> getAllchildBykindergarten(int id); 
	
	public void unsubscribeChildren(int id);

}
