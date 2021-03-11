package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements IEventService {
	
	@Autowired
	EventRepository eventRepository;

	@Override
	public void addEvent(Event event) {
		eventRepository.save(event);
		
	}

	@Override
	public void deleteEvent(int id) {
		eventRepository.deleteById(id);
	}

	@Override
	public void updateEvent(int id, String Title, Date opening, Date Duration, Event_for event_For,
			Event_Activity event_Activity) {
		Event event = eventRepository.findById(id).orElse(null);
		event.setTitle(Title);
		event.setDuration(Duration);
		event.setEvent_Activity(event_Activity);
		event.setOpening(opening);
		event.setEvent_For(event_For);
		eventRepository.save(event);
	}

	@Override
	public Event retrieveEvent(int id) {
		Event event = eventRepository.findById(id).orElse(null);
		return event;
	}

	@Override
	public List<Event> retrieveAllEvents() {
		List<Event> event = (List<Event>) eventRepository.findAll();
		return event;
	}

	
}
