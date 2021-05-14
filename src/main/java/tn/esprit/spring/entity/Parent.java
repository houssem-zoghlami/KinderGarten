package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Genders;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Parent extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private int phone;
	private String image;

	@Enumerated(EnumType.STRING)
	private Genders gender;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@ManyToMany(mappedBy = "parent")
	private List<Event> event;

	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Child> child;
	
	
	@JsonBackReference
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Bill> bill;

}
