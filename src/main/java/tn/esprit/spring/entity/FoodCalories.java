package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity


public class FoodCalories {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String value;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodCalories() {
		super();
	}

	public FoodCalories(Long id, String value, String name) {
		super();
		this.id = id;
		this.value = value;
		this.name = name;
	}
	
	
	
	
	
	
	

}
