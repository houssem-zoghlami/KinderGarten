package tn.esprit.spring.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.MedicaleVisit;
import tn.esprit.spring.service.MedicalVisitImpl;

@RestController

public class MedicalController  {
	
	@Autowired
	MedicalVisitImpl medicalVisit;
	
	
	//crud visit medical
	
	@PostMapping("/addvisit")
	@ResponseBody
	public void addMedicalVisit(@RequestBody MedicaleVisit m) {

		medicalVisit.add(m);
	}
	
	
	@PutMapping("/updatevisit")
	@ResponseBody
	public void updateMedicalVisit(MedicaleVisit m){
		medicalVisit.update(m);
		
	}
	
	
	@DeleteMapping("/deletevisit/{id}")
	@ResponseBody
	public void deleteVisitMedical(@PathVariable int id){
		medicalVisit.remove(id);
		
	}
	
	@GetMapping("/getVisits")
	@ResponseBody
	public void getVisit(){
		medicalVisit.getall();
	}
	
	
	@GetMapping("/getVisit/{id}")
	@ResponseBody
	public void getVisit(@PathVariable int id){
		medicalVisit.getByid(id);
	}
	
	

}
