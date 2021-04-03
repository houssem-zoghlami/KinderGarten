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
	private Long id_child;
	private String firstname;
	private String lastname;

	private Genders gender;
	private boolean subscribe;
	private int age;
	@Temporal(TemporalType.DATE)
	private Date date;

	@Enumerated(EnumType.STRING)
	private Level level;

	@ManyToOne
	private Parent parent;
	@ManyToOne
	private Kindergarten kindergarten;

	
}
