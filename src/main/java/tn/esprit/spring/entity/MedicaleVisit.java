package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class MedicaleVisit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	 @Temporal(TemporalType.TIMESTAMP)
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private Date dateStart;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private Date dateEnd;
	 
	 
	 @ManyToOne
	 private User doctor;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public User getDoctor() {
		return doctor;
	}


	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	 
	 
	

}
