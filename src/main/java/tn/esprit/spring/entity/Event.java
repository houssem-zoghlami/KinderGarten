package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_event;

	private String title;

	@Temporal(TemporalType.DATE)
	private Date opening;

	@Temporal(TemporalType.DATE)
	private Date Duration;

	private int nbrs_Participants = 0;
	private Event_for event_For;
	private Event_Activity event_Activity;
	private State_event State_event;

	@ManyToMany
	private List<Parent> parent;
	@ManyToMany
	private List<Kindergarten> kindergarten;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Coupon> coupon;



	public Event(int id_event, String title, Date opening, Date duration, int nbrs_participants, Event_for event_For,
			Event_Activity event_Activity, State_event state_event, List<Parent> parent,
			List<Kindergarten> kindergarten, List<Coupon> coupon) {
		super();
		this.id_event = id_event;
		this.title = title;
		this.opening = opening;
		Duration = duration;
		this.nbrs_Participants = nbrs_participants;
		this.event_For = event_For;
		this.event_Activity = event_Activity;
		State_event = state_event;
		this.parent = parent;
		this.kindergarten = kindergarten;
		this.coupon = coupon;
	}

	public Event() {
		super();
	}

	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return nbrs_Participants;
	}

	public void setNbrs_participants(int nbrs_participants) {
		this.nbrs_Participants = nbrs_participants;
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

	public State_event getState_event() {
		return State_event;
	}

	public void setState_event(State_event state_event) {
		State_event = state_event;
	}

	public List<Parent> getParent() {
		return parent;
	}

	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}

	public int getNbrs_Participants() {
		return nbrs_Participants;
	}

	public void setNbrs_Participants(int nbrs_Participants) {
		this.nbrs_Participants = nbrs_Participants;
	}

	public List<Kindergarten> getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(List<Kindergarten> kindergarten) {
		this.kindergarten = kindergarten;
	}

	public List<Coupon> getCoupon() {
		return coupon;
	}

	public void setCoupon(List<Coupon> coupon) {
		this.coupon = coupon;
	}



}
