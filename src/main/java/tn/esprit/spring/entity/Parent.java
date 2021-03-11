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
public class Parent extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String LastName;
	private String Email;
	private String Address;
	private int Phone;
	private Gender Gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	


	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Event> event;


}
