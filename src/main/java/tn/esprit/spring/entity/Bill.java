package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_bill;

	@Temporal(TemporalType.DATE)
	private Date date_bill;

	private float total_costs;

	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
	private List<Coupon> coupon;



	public Bill(Long id_bill, Date date_bill, float total_costs, List<Coupon> coupon) {
		super();
		this.id_bill = id_bill;
		this.date_bill = date_bill;
		this.total_costs = total_costs;
		this.coupon = coupon;
	}

	public Bill() {

	}

	public Long getId_bill() {
		return id_bill;
	}

	public void setId_bill(Long id_bill) {
		this.id_bill = id_bill;
	}

	public Date getDate_bill() {
		return date_bill;
	}

	public void setDate_bill(Date date_bill) {
		this.date_bill = date_bill;
	}

	public float getTotal_costs() {
		return total_costs;
	}

	public void setTotal_costs(float total_costs) {
		this.total_costs = total_costs;
	}

	public List<Coupon> getCoupon() {
		return coupon;
	}

	public void setCoupon(List<Coupon> coupon) {
		this.coupon = coupon;
	}

}
