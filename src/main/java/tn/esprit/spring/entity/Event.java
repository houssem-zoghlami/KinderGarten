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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	private float cost;

	@ManyToMany
	private List<Parent> parent;

	@ManyToOne
	private List<Kindergarten> kindergarten;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Coupon> coupon;
	
	@OneToOne (mappedBy = "event", cascade = CascadeType.ALL)
	private Bill bill; 

}
