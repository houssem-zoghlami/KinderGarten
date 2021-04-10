package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.State_event;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Event implements Serializable {

	private static final long serialVersionUID = 1496106056885440532L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_event;

	private String title;

	@Temporal(TemporalType.DATE)
	private Date opening;

	private int Duration = 0;

	private int nbrs_Participants = 0;
	
	@Lob
	private byte[] image;

	@Enumerated(EnumType.STRING)
	private Event_for eventFor;

	@Enumerated(EnumType.STRING)
	private Event_Activity eventActivity;

	@Enumerated(EnumType.STRING)
	private State_event stateEvent;

	@ManyToMany
	private List<Parent> parent;

	@ManyToOne
	private Kindergarten kindergarten;

	@OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
	private Coupon coupon;

	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public String getTitle() {
		return title;
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

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public int getNbrs_Participants() {
		return nbrs_Participants;
	}

	public void setNbrs_Participants(int nbrs_Participants) {
		this.nbrs_Participants = nbrs_Participants;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Event_for getEventFor() {
		return eventFor;
	}

	public void setEventFor(Event_for eventFor) {
		this.eventFor = eventFor;
	}

	public Event_Activity getEventActivity() {
		return eventActivity;
	}

	public void setEventActivity(Event_Activity eventActivity) {
		this.eventActivity = eventActivity;
	}

	public State_event getStateEvent() {
		return stateEvent;
	}

	public void setStateEvent(State_event stateEvent) {
		this.stateEvent = stateEvent;
	}

	public List<Parent> getParent() {
		return parent;
	}

	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Event(int id_event, String title, Date opening, int duration, int nbrs_Participants, byte[] image,
			Event_for eventFor, Event_Activity eventActivity, State_event stateEvent, List<Parent> parent,
			Kindergarten kindergarten, Coupon coupon) {
		super();
		this.id_event = id_event;
		this.title = title;
		this.opening = opening;
		Duration = duration;
		this.nbrs_Participants = nbrs_Participants;
		this.image = image;
		this.eventFor = eventFor;
		this.eventActivity = eventActivity;
		this.stateEvent = stateEvent;
		this.parent = parent;
		this.kindergarten = kindergarten;
		this.coupon = coupon;
	}

	public Event() {
		super();
	}
	
	
	
	
	
	
}
