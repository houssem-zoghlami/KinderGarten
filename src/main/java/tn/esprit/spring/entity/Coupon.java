package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Coupon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_coupon;

	private int price;
	private int nbrs_coupon;

	@Temporal(TemporalType.DATE)
	private Date date_coupon;

	@ManyToOne
	private Event event;

	@ManyToOne 
	private Bill bill;
	
	@OneToOne 
	private Parent parent;

	public Coupon(Long id_coupon, int price, int nbrs_coupon, Date date_coupon, Event event, Bill bill) {

		this.id_coupon = id_coupon;
		this.price = price;
		this.nbrs_coupon = nbrs_coupon;
		this.date_coupon = date_coupon;
		this.event = event;
		this.bill = bill;
	}

	public Coupon() {
	}

	public Long getId_coupon() {
		return id_coupon;
	}

	public void setId_coupon(Long id_coupon) {
		this.id_coupon = id_coupon;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNbrs_coupon() {
		return nbrs_coupon;
	}

	public void setNbrs_coupon(int nbrs_coupon) {
		this.nbrs_coupon = nbrs_coupon;
	}

	public Date getDate_coupon() {
		return date_coupon;
	}

	public void setDate_coupon(Date date_coupon) {
		this.date_coupon = date_coupon;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
