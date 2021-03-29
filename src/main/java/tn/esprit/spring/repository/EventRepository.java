package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.entity.State_event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

	@Query("select e from Event e where e.event_Activity=:event_Activity")
	public List<Event> getAllEventByActivity(@Param("event_Activity") Event_Activity event_Activity);

	@Query("select e from Event e where e.event_for=:event_for")
	public List<Event> getAllEventByFor(@Param("event_for") Event_for event_for);

	@Query("select e from Event e where e.state_event=:state_event")
	public List<Event> getAllEventByState(@Param("state_event") State_event state_event);

	@Query("SELECT count(parent) FROM Event e where e.id_event =:id")
	public int countParent(@Param("id") int id);

	@Query("SELECT e from Event e where e.opening = CURRENT_DATE()")
	public List<Event> getAllEventForToday();

}
