package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "Please provide your password")
	private String password;

	@NotEmpty(message = "Please choose a Role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Temporal(TemporalType.DATE)
	private Date dateInscription;

	// @OneToMany(cascade = CascadeType.ALL,mappedBy="post")
	// private List<Post> post;

}
