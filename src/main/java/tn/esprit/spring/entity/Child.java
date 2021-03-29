package tn.esprit.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data

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

	public Child(Long id_child, String firstname, String lastname, Genders gender, boolean subscribe, int age,
			Date date, Level level, Parent parent, Kindergarten kindergarten) {

		this.id_child = id_child;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.subscribe = subscribe;
		this.age = age;
		this.date = date;
		this.level = level;
		this.parent = parent;
		this.kindergarten = kindergarten;
	}

	public Child() {
		super();
	}

	public Long getId_child() {
		return id_child;
	}

	public void setId_child(Long id_child) {
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

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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

}
