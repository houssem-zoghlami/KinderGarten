package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Child;

public interface IChildService {

	public void addChild(Child child, int parentid);

	public void deleteChild(int id);

	public Child updateChild(int id, Child child);

	public Child retrieveChild(int id);

	public List<Child> retrieveAllChild();

}
