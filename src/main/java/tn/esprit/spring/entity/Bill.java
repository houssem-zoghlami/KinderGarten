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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_bill;

	@Temporal(TemporalType.DATE)
	private Date date_bill;

	private double discount = 0;
	
	private float Nbrs_month = 1;

	private double total_costs;

	private double tax = 0.2;

	@Enumerated(EnumType.STRING)
	private Payment payment;

	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	private Parent parent;

	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	private Kindergarten kindergarten;
}
