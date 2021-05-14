package tn.esprit.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	private String image;

	@JsonIgnore
	@OneToMany(mappedBy = "kindergarten", cascade = CascadeType.ALL)
	private List<Event> event;

	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy ="kindergarten",cascade = CascadeType.ALL)
	private List<Child> child;

	@JsonBackReference
	@OneToMany(mappedBy ="kindergarten",cascade = CascadeType.ALL)
	private List<Bill> bill;

}
