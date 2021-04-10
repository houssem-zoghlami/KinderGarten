package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	
	
	// @OneToMany(cascade = CascadeType.ALL,mappedBy="post")
		// private List<Post> post;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public User(int id, String password, Role role, Date dateInscription) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
		this.dateInscription = dateInscription;
	}

	public User() {
		super();
	}

	
	
	
	

}
