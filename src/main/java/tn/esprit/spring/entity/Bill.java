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

	public int getId_bill() {
		return id_bill;
	}

	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}

	public Date getDate_bill() {
		return date_bill;
	}

	public void setDate_bill(Date date_bill) {
		this.date_bill = date_bill;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getNbrs_month() {
		return Nbrs_month;
	}

	public void setNbrs_month(float nbrs_month) {
		Nbrs_month = nbrs_month;
	}

	public double getTotal_costs() {
		return total_costs;
	}

	public void setTotal_costs(double total_costs) {
		this.total_costs = total_costs;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

	public Bill(int id_bill, Date date_bill, float discount, float nbrs_month, double total_costs, double tax,
			Payment payment, Parent parent, Kindergarten kindergarten) {
		super();
		this.id_bill = id_bill;
		this.date_bill = date_bill;
		this.discount = discount;
		Nbrs_month = nbrs_month;
		this.total_costs = total_costs;
		this.tax = tax;
		this.payment = payment;
		this.parent = parent;
		this.kindergarten = kindergarten;
	}

	public Bill() {
		super();
	}
	
	
	
}
