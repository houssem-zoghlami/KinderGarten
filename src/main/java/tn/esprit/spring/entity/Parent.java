package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Genders;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Parent extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private int phone;

	private Genders gender;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@ManyToMany(mappedBy = "parent")
	private List<Event> event;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Child> child;

	@OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
	private Coupon coupon;

	public Parent(String firstName, String lastName, String email, String address, int phone, Genders gender,
			Date birthday, List<Event> event, List<Child> child) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.event = event;
		this.child = child;
	}

	public Parent() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Genders getGender() {
		return this.gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public List<Child> getChild() {
		return child;
	}

	public void setChild(List<Child> child) {
		this.child = child;
	}

}
