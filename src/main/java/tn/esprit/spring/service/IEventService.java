package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;



public interface IEventService {
	
	public void addEvent(Event event);

	public void deleteEvent(int id);

	public void updateEvent(int id, String Title, Date opening, Date Duration, Event_for event_For,Event_Activity event_Activity);

	public Event retrieveEvent(int id);
	
	public List<Event> retrieveAllEvents();

}
