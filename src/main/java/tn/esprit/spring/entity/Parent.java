package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	


	
	public Parent(int id, String login, String password,Role role, Date dateRegistration) {
		super(id, login, password, role, dateRegistration);
	}
	

	public Parent(int id, String login, String password,Role role, Date dateRegistration,
			String firstName, String lastName, String email, String address, int phone,
			Gender gender, Date birthday, Event event) {
		super(id, login, password, role, dateRegistration);
		this.firstName = firstName;
		LastName = lastName;
		Email = email;
		Address = address;
		Phone = phone;
		Gender = gender;
		this.birthday = birthday;
		this.event = event;
	}


	@ManyToMany (mappedBy = "parent")
	Event event;

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public Gender getGender() {
		return Gender;
	}

	public void setGender(Gender gender) {
		Gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
