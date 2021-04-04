package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.service.IEventService;

@RestController
public class EventController {

	@Autowired
	IEventService ieventservice;

	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/add-event
	@PostMapping(value = "/add-event")
	@ResponseBody
	public Event adEvents(@RequestBody Event event) {
		ieventservice.addEvent(event);
		return event;
	}

	// http://localhost:8082/springMVC/servlet/modify-event/{event-id}
	@PutMapping("/modify-event/{event-id}")
	@ResponseBody
	public Event modifyEvent(@PathVariable("event-id") int eventId, @RequestBody Event event) {
		return ieventservice.updateEvent(eventId, event);
	}

	// http://localhost:8082/springMVC/servlet/delete-event/{event-id}
	@DeleteMapping("/delete-event/{event-id}")
	@ResponseBody
	public void removeEvent(@PathVariable(name = "event-id") int eventId) {
		ieventservice.deleteEvent(eventId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-events
	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> getEvents() {
		List<Event> list = ieventservice.retrieveAllEvents();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-event/{event-id}
	@GetMapping(path = "/retrieve-event/{event-id}")
	@ResponseBody
	public Event retrieveEvent(@PathVariable("event-id") int eventId) {
		return ieventservice.retrieveEvent(eventId);
	}

	///////////////////////////////////////////////////////////////// OTHERS////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/get-Events-By-For/{Event-for}
	@GetMapping("/get-Events-By-For/{Event-for}")
	@ResponseBody
	public List<Event> getEventsByFor(@PathVariable("Event-for") Event_for event_for) {
		List<Event> list = ieventservice.getAllEventByFor(event_for);
		return list;
	}

	// http://localhost:8082/springMVC/servlet/get-Events-By-Activity/{Event-Activity}
	@GetMapping("/get-Events-By-Activity/{Event-Activity}")
	@ResponseBody
	public List<Event> getEventsByActivity(@PathVariable("Event-Activity") Event_Activity event_Activity) {
		List<Event> list = ieventservice.getAllEventByActivity(event_Activity);
		return list;
	}

	// http://localhost:8082/springMVC/servlet/get-Events-For-Today
	@GetMapping("/get-Events-For-Today")
	@ResponseBody
	public List<Event> getEventsForToday() {
		List<Event> list = ieventservice.getAllEventForToday();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/get-Events-Count/{id-event}
	@GetMapping("/get-Events-Count/{id-event}")
	@ResponseBody
	public int getEventsCount(@PathVariable("id-event") int id) {

		return ieventservice.countParent(id);
	}

}
