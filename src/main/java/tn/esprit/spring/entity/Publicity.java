package tn.esprit.spring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="T_Publicity")

public class Publicity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private String marque;
	private String category;
	private float priceSponsoring;
	private String image;
	
	private float average;

	@ManyToOne
	@JsonIgnore
	private User user;
	
	

}
