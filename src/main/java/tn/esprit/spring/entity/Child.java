package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_child;

	private String firstname;
	private String lastname;

	@Enumerated(EnumType.STRING)
	private Genders gender;

	private boolean subscribe = false;

	private int age;
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	private Parent parent;
	@ManyToOne
	private Kindergarten kindergarten;

}
