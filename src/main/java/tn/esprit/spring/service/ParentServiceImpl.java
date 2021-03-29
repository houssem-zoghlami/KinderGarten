package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.ParentRepository;

@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	ParentRepository parentRepository;

	@Override
	public void addParent(Parent parent) {
		parentRepository.save(parent);

	}

	@Override
	public void deleteParent(int id) {
		parentRepository.deleteById(id);
	}

	@Override
	public void updateParent(int id, String firstName, String lastName, int phone) {

		Parent parent = parentRepository.findById(id).orElse(null);
		parent.setFirstName(firstName);
		parent.setLastName(lastName);
		parent.setPhone(phone);
		parentRepository.save(parent);
	}

	@Override
	public Parent retrieveParent(int id) {
		Parent parent = parentRepository.findById(id).orElse(null);
		return parent;
	}

	@Override
	public List<Parent> retrieveAllParents() {
		List<Parent> parent = (List<Parent>) parentRepository.findAll();
		return parent;
	}

	@Override
	public List<Parent> getAllParentByEvent(Event event) {
		List<Parent> parent = (List<Parent>) parentRepository.getAllParentByEvent(event);
		return parent;
	}

	@Override
	public List<Parent> getAllParentByAddress(String address) {
		List<Parent> parent = (List<Parent>) parentRepository.getAllParentByAddress(address);
		return parent;
	}

	@Override
	public List<Parent> getAllParentByLastName(String lastName) {
		List<Parent> parent = (List<Parent>) parentRepository.getAllParentByLastName(lastName);
		return parent;
	}

	@Override
	public List<Parent> getAllParentByFirstName(String firstName) {
		List<Parent> parent = (List<Parent>) parentRepository.getAllParentByFirstName(firstName);
		return parent;
	}

	@Override
	public Parent retrieveParentByPhone(int phone) {
		Parent parent = parentRepository.findByPhone(phone);
		if (parent == null) {
			return null;
		}
		return parent;
	}

}
