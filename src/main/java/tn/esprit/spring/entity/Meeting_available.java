package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class Meeting_available implements Serializable {

	private static final long serialVersionUID = 1496106856885440532L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_meeting;

	@Temporal(TemporalType.DATE)
	private Date opening;

	@Temporal(TemporalType.DATE)
	private Date closing;

	@Enumerated(EnumType.STRING)
	private Meeting_type meetingtype;
	
	@Enumerated(EnumType.STRING)
	private Meeting_state meetingstate;

	@ManyToOne
	private Kindergarten kindergarten;

}
