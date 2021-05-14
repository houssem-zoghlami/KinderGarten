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

	private String image;

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
	
}
