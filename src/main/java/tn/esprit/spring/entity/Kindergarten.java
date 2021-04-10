package tn.esprit.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@Getter
@Setter

public class Kindergarten extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;;
	private String name;
	private String email;
	private String description;
	private String address;
	private int nombreemploye;
	private double price_month=0;
	private double discount=0;
	
	@Lob
	private byte[] image;

	@OneToMany(mappedBy = "kindergarten", cascade = CascadeType.ALL)
	private List<Event> event;
	
	@OneToMany(mappedBy ="kindergarten",cascade = CascadeType.ALL)
	private List<Child> child;
	
	@OneToMany(mappedBy ="kindergarten",cascade = CascadeType.ALL)
	private List<Bill> bill;
	
	// @ManyToMany(cascade = CascadeType.ALL)
	// private List<User> user;
	//
	// @OneToMany(cascade = CascadeType.ALL,mappedBy="child")
	// private List<Child> child;

}
