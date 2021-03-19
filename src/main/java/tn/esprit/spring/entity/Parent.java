package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Parent extends AppUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//private String firstName;
	//private String LastName;
	//private String Email;
	private String Address;
	private int Phone;
	private Gender Gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	




}
