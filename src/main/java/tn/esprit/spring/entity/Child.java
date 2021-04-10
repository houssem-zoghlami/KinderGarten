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

	private int age;
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	private Parent parent;
	@ManyToOne
	private Kindergarten kindergarten;
	public int getId_child() {
		return id_child;
	}
	public void setId_child(int id_child) {
		this.id_child = id_child;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Genders getGender() {
		return gender;
	}
	public void setGender(Genders gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	public Child(int id_child, String firstname, String lastname, Genders gender, int age, Date date, Parent parent,
			Kindergarten kindergarten) {
		super();
		this.id_child = id_child;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.date = date;
		this.parent = parent;
		this.kindergarten = kindergarten;
	}
	public Child() {
		super();
	}
	
	
	

	
}
