package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_coupon;

	private int price = 0;

	private int nbrs_coupon = 0;

	@Temporal(TemporalType.DATE)
	private Date date_coupon;

	@OneToOne
	private Event event;

	public int getId_coupon() {
		return id_coupon;
	}

	public void setId_coupon(int id_coupon) {
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

	public Coupon(int id_coupon, int price, int nbrs_coupon, Date date_coupon, Event event) {
		super();
		this.id_coupon = id_coupon;
		this.price = price;
		this.nbrs_coupon = nbrs_coupon;
		this.date_coupon = date_coupon;
		this.event = event;
	}

	public Coupon() {
		super();
	}
	
	
}
