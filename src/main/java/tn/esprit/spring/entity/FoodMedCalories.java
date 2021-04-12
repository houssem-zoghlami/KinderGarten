package tn.esprit.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class FoodMedCalories {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private float value;
	private String name;
	private String categorie;
	
	//@JsonIgnore  
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="foodmedcalories",fetch=FetchType.EAGER)
	
	//private MedicalRec medicalrec;
	

}
