package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	private String Login;
	private String Password;
	private Role Role;
	
	@Temporal(TemporalType.DATE)
	private Date dateRegistration;
	
	
	public User() {
		super();
	}
	
	public User(int id, String login, String password, tn.esprit.spring.entity.Role role, Date dateRegistration) {
		super();
		this.id = id;
		Login = login;
		Password = password;
		Role = role;
		this.dateRegistration = dateRegistration;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}

	public Date getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}
	
	

}


