package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.repository.ParentRepository;

@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	ParentRepository parentRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	KindergartenRepository kindergartenRepository;

	@Autowired
	IEventService ieventService;

	@Autowired
	IChildService ichildService;

	@Autowired
	IBillService ibillService;

	@Override
	public void addParent(Parent parent) {
		parentRepository.save(parent);
	}

	@Override
	public void deleteParent(int id) {
		parentRepository.deleteById(id);
	}

	@Override
	public Parent updateParent(int id, Parent parent) {

		Parent parents = parentRepository.findById(id).orElse(null);

		if (parent.getPhone() != 0) {
			parents.setPhone(parent.getPhone());
		}
		if (parent.getAddress() != null) {
			parents.setAddress(parent.getAddress());
		}
		if (parent.getFirstName() != null) {
			parents.setFirstName(parent.getFirstName());
		}
		if (parent.getLastName() != null) {
			parents.setLastName(parent.getLastName());
		}
		if (parent.getImage() != null) {
			parents.setImage(parent.getImage());
		}

		parentRepository.save(parents);
		return parents;
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

	@Override
	public int participateParentInEvent(int idParent, int idEvent) {

		Parent parent = parentRepository.findById(idParent).orElse(null);
		Event event = eventRepository.findById(idEvent).orElse(null);

		int nbrs_Partivipants = event.getNbrs_Participants();
		event.setNbrs_Participants(nbrs_Partivipants + 1);
		event.getParent().add(parent);
		eventRepository.save(event);
		parentRepository.save(parent);
		return 1;
	}

	@Override
	public int unparticipateParentInEvent(int idParent, int idEvent) {
		Parent parent = parentRepository.findById(idParent).orElse(null);
		Event event = eventRepository.findById(idEvent).orElse(null);
		List<Event> parentEvents = parent.getEvent();

		for (Event parentEvent : parentEvents) {
			if (parentEvent == event) {
				int nbrs_Partivipants = event.getNbrs_Participants();
				event.setNbrs_Participants(nbrs_Partivipants - 1);
				event.getParent().remove(parent);
				eventRepository.save(event);
				return 1;
			}
		}
		return 0;
	}
	
	@Override
	public int joinKindergarten(int idParent, int idKindergarten, int month,int idchild) {
		Parent parent = parentRepository.findById(idParent).orElse(null);
		Kindergarten kindergarten = kindergartenRepository.findById(idKindergarten).orElse(null);
		Child child = (Child) ichildService.retrieveChild(idchild);
		if(child.getParent()!= parent)
		{
			return 0;
		}	
		ibillService.addBill(month, idKindergarten, idParent);
		kindergarten.getChild().add(child);
		kindergartenRepository.save(kindergarten);
		parentRepository.save(parent);
		return 1;
	}

}
