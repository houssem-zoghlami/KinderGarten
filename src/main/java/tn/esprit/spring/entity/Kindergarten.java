package tn.esprit.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
	
	@Lob
	private byte[] image;

	@OneToMany(mappedBy = "kindergarten", cascade = CascadeType.ALL)
	private List<Event> event;
	
	@OneToMany(mappedBy ="kindergarten",cascade = CascadeType.ALL)
	private List<Child> child;
	
	@OneToMany(mappedBy ="kindergarten",cascade = CascadeType.ALL)
	private List<Bill> bill;
	
	
	// @ManyToMany(cascade = CascadeType.ALL)
	// private List<User> user;
	//
	// @OneToMany(cascade = CascadeType.ALL,mappedBy="child")
	// private List<Child> child;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNombreemploye() {
		return nombreemploye;
	}

	public void setNombreemploye(int nombreemploye) {
		this.nombreemploye = nombreemploye;
	}

	public double getPrice_month() {
		return price_month;
	}

	public void setPrice_month(double price_month) {
		this.price_month = price_month;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public List<Child> getChild() {
		return child;
	}

	public void setChild(List<Child> child) {
		this.child = child;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public Kindergarten(int id, String password, Role role, Date dateInscription, String name, String email,
			String description, String address, int nombreemploye, double price_month, double discount, byte[] image,
			List<Event> event, List<Child> child, List<Bill> bill) {
		super(id, password, role, dateInscription);
		this.name = name;
		this.email = email;
		this.description = description;
		this.address = address;
		this.nombreemploye = nombreemploye;
		this.price_month = price_month;
		this.discount = discount;
		this.image = image;
		this.event = event;
		this.child = child;
		this.bill = bill;
	}

	public Kindergarten(int id, String password, Role role, Date dateInscription) {
		super(id, password, role, dateInscription);
	}
	

	
	
	

}
