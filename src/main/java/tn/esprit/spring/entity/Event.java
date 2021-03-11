package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String Title;

	@Temporal(TemporalType.DATE)
	private Date opening;

	@Temporal(TemporalType.DATE)
	private Date Duration;

	private int nbr_participants;
	private Event_for event_For;
	private Event_Activity event_Activity;

	/**
	 *
	 */
	@ManyToMany(mappedBy = "event",cascade = CascadeType.ALL)
     private Set<Parent> parent;
}