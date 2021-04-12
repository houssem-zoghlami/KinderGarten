package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name = "chat")
@Entity
public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sender")
	private String sender;
	
	@Column(name = "reciver")
	private String reciver;
	
	@Column(name = "message")
	private String messagecontent;

	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserC user;


	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	public UserC getUser() {
		return user;
	}

	public void setUser(UserC user) {
		this.user = user;
	}



	public Chat() {
		super();
	}

	public Chat(int id, String sender, String reciver, String messagecontent) {
		super();
		this.id = id;
		this.sender = sender;
		this.reciver = reciver;
		this.messagecontent = messagecontent;
	}


}
