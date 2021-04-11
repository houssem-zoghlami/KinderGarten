package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Claim implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String object;
	private String description;
	private String type;
	private String state;
	private Instant created;

	@ManyToOne
	private User user;
	
	

}
