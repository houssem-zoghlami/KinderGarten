package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int employee_id; 
	@Enumerated(EnumType.STRING)
	private Job job;
	private String employeename;
	private int age;
  @ManyToOne
  Kindergarten kindergarten;
public int getEmployee_id() {
	return employee_id;
}
public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}
public Job getJob() {
	return job;
}
public void setJob(Job job) {
	this.job = job;
}
public String getEmployeename() {
	return employeename;
}
public void setEmployeename(String employeename) {
	this.employeename = employeename;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Kindergarten getKindergarten() {
	return kindergarten;
}
public void setKindergarten(Kindergarten kindergarten) {
	this.kindergarten = kindergarten;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Employee(int employee_id, Job job, String employeename, int age, Kindergarten kindergarten) {
	super();
	this.employee_id = employee_id;
	this.job = job;
	this.employeename = employeename;
	this.age = age;
	this.kindergarten = kindergarten;
}
public Employee(){
	super ();
}
	
}
