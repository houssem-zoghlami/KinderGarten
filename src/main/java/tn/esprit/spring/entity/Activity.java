package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Activitys activityType;
	private Date ActivityDate;
	
	
	
	
	//ajouter la relation manytoonr
	
	
	
	public Activity() {
		super();
	}




	public  int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Activitys getActivityType() {
		return activityType;
	}




	public void setActivityType(Activitys activityType) {
		this.activityType = activityType;
	}




	public Date getActivityDate() {
		return ActivityDate;
	}




	public void setActivityDate(Date activityDate) {
		ActivityDate = activityDate;
	}
	
	
	
	
	
	

}
