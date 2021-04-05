package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.MedicaleVisit;
import tn.esprit.spring.repository.MedicalvisitRepository;
@Service
public class MedicalVisitImpl implements IMedicalVisit{
	@Autowired
	 MedicalvisitRepository medicalvisitRepository;
	
//post
	@Override
	public void add(MedicaleVisit m) {
		medicalvisitRepository.save(m);
		
	}
//delete
	@Override
	public void remove(int id) {
		medicalvisitRepository.deleteById(id);
		
	}
//put
	@Override
	public void update(MedicaleVisit m) {
		medicalvisitRepository.save(m);
		
	}
//get
	@Override
	public List<MedicaleVisit> getall(){
		return  medicalvisitRepository.findAll();
	}

	@Override
	public MedicaleVisit getByid(int id){ //get by id
		return  medicalvisitRepository.findById(id).orElse(null);
	
}
	
	

	
	

}
