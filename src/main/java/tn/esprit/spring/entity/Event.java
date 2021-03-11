package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	private String Title;
	
	@Temporal(TemporalType.DATE)
	private Date opening;
	
	@Temporal(TemporalType.DATE)
	private Date Duration;
	
	private int nbrs_participants;
	private Event_for event_For;
	private Event_Activity event_Activity;

	@ManyToMany
	Parent parent;
	@ManyToMany 
	Kindergarten kindergarten;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getOpening() {
		return opening;
	}

	public void setOpening(Date opening) {
		this.opening = opening;
	}

	public Date getDuration() {
		return Duration;
	}

	public void setDuration(Date duration) {
		Duration = duration;
	}

	public int getNbrs_participants() {
		return nbrs_participants;
	}

	public void setNbrs_participants(int nbrs_participants) {
		this.nbrs_participants = nbrs_participants;
	}

	public Event_for getEvent_For() {
		return event_For;
	}

	public void setEvent_For(Event_for event_For) {
		this.event_For = event_For;
	}

	public Event_Activity getEvent_Activity() {
		return event_Activity;
	}

	public void setEvent_Activity(Event_Activity event_Activity) {
		this.event_Activity = event_Activity;
	}

	public Event(int id, String title, Date opening, Date duration, int nbrs_participants, Event_for event_For,
			Event_Activity event_Activity) {
		super();
		this.id = id;
		Title = title;
		this.opening = opening;
		Duration = duration;
		this.nbrs_participants = nbrs_participants;
		this.event_For = event_For;
		this.event_Activity = event_Activity;
	}

	public Event() {
		super();
	}
	
	 
	
}
