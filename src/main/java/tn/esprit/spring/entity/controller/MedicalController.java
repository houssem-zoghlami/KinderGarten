package tn.esprit.spring.entity.controller;

import java.util.List;

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
	public MedicaleVisit addMedicalVisit(@RequestBody MedicaleVisit m) {

		return medicalVisit.save(m);
	}
	
	@PostMapping("/addvisits")
	@ResponseBody
	public List<MedicaleVisit> addMedicalVisits(@RequestBody List<MedicaleVisit> m) {

		return medicalVisit.saveall(m);
	}
	
	//get
	
	@GetMapping("/getVisits")
	@ResponseBody
	public List<MedicaleVisit> getallVisit(){
		return medicalVisit.getall();
	}
	
	
	@GetMapping("/getVisit/{id}")
	@ResponseBody
	public MedicaleVisit getid(@PathVariable int id){
		return medicalVisit.getByid(id);
	}
	
	//put 
	
	@PutMapping("/updatevisit")
	@ResponseBody
	public void updateMedicalVisit(MedicaleVisit m){
		medicalVisit.update(m);
		
	}
	//delete
	
	@DeleteMapping("/deletevisit/{id}")
	@ResponseBody
	public void deleteVisitMedical(@PathVariable int id){
		medicalVisit.remove(id);
		
	}
	

}
