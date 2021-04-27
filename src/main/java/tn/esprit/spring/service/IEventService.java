package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Coupon;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.entity.State_event;

public interface IEventService {

	public Event addEvent(Event event,int id_kindergarten);

	public void deleteEvent(int id);

	public Event updateEvent(int id, Event event);

	public Event retrieveEvent(int id);

	public List<Event> retrieveAllEvents();

	public List<Event> getAllEventForToday();

	public int countParent(int id);

	public List<Event> getAllEventByState(State_event state_event);

	public List<Event> getAllEventByFor(Event_for event_for);

	public List<Event> getAllEventByActivity(Event_Activity event_Activity);

	public Event addCouponInEvent(int id, Coupon coupon);

	public State_event makeState(Date date, int duration);

	public void sendMailNewEvent(String subject, String recipient, String message);

}
