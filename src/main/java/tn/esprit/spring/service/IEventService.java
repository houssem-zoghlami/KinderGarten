package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.entity.State_event;

public interface IEventService {

	public void addEvent(Event event);

	public void deleteEvent(int id);

	public Event updateEvent(int id, Event event);

	public Event retrieveEvent(int id);

	public List<Event> retrieveAllEvents();

	public List<Event> getAllEventForToday();

	public int countParent(int id);

	public List<Event> getAllEventByState(State_event state_event);

	public List<Event> getAllEventByFor(Event_for event_for);

	public List<Event> getAllEventByActivity(Event_Activity event_Activity);

}
