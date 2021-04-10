package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_notification;

	private String Subject;

	@Temporal(TemporalType.DATE)
	private Date Duration;

	private boolean state_notification;

	public Long getId_notification() {
		return id_notification;
	}

	public void setId_notification(Long id_notification) {
		this.id_notification = id_notification;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Date getDuration() {
		return Duration;
	}

	public void setDuration(Date duration) {
		Duration = duration;
	}

	public boolean isState_notification() {
		return state_notification;
	}

	public void setState_notification(boolean state_notification) {
		this.state_notification = state_notification;
	}

	public Notification(Long id_notification, String subject, Date duration, boolean state_notification) {
		super();
		this.id_notification = id_notification;
		Subject = subject;
		Duration = duration;
		this.state_notification = state_notification;
	}

	public Notification() {
		super();
	}
	
	
	

}
