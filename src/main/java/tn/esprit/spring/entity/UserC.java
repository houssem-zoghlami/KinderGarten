package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;


	
	@Entity

	@Table(name="users")
	public class UserC{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		
		private String email;
		
		@NotNull
		@Column(unique = true, length = 20)
		private String userName;

		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		

		public UserC(long id, String email, String userName) {
			super();
			this.id = id;
			this.email = email;
			this.userName = userName;
			
		}

		public UserC() {
			super();
		}
		
		
		
	}


