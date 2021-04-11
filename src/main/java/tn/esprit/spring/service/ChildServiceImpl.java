package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.ChildRepository;
import tn.esprit.spring.repository.ParentRepository;

@Service
public class ChildServiceImpl implements IChildService {

	@Autowired
	ChildRepository childRepository;

	@Autowired
	ParentRepository parentRepository;

	@Override
	public void addChild(Child child, int parentid) {
		Parent parent = parentRepository.findById(parentid).orElse(null);
		child.setParent(parent);
		childRepository.save(child);
	}

	@Override
	public void deleteChild(int id) {
		childRepository.deleteById(id);

	}

	@Override
	public Child updateChild(int id, Child child) {
		Child childs = childRepository.findById(id).orElse(null);

		if (child.getAge()!= 0) {
			childs.setAge(child.getAge());
		}
		if (child.getDate() != null) {
			childs.setDate(child.getDate());
		}
		if (child.getFirstname() != null) {
			childs.setFirstname(child.getFirstname());
		}
	
		childRepository.save(childs);
		return childs;
	}

	@Override
	public Child retrieveChild(int id) {
		Child child = childRepository.findById(id).orElse(null);
		return child;
	}

	@Override
	public List<Child> retrieveAllChild() {
		List<Child> child = (List<Child>) childRepository.findAll();
		return child;
	}

}
