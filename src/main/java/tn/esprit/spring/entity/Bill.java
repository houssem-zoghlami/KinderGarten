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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_bill;

	@Temporal(TemporalType.DATE)
	private Date date_bill;

	private float discount = 0;
	
	private float Nbrs_month = 1;

	private double total_costs;

	private double tax = 0.2;

	@Enumerated(EnumType.STRING)
	private Payment payment;

	@ManyToOne
	private Parent parent;

	@ManyToOne
	private Kindergarten kindergarten;


	
	
	
	
	
}
