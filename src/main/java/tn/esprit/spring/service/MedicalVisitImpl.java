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
	public MedicaleVisit save(MedicaleVisit m) {//create one
		return medicalvisitRepository.save(m);
	}
	
	@Override
	public List<MedicaleVisit> saveall(List<MedicaleVisit> m){//create list of medical visit
		return medicalvisitRepository.saveAll(m);
		
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
		
		
		
//delete
	@Override
	public String remove(int id) {
		medicalvisitRepository.deleteById(id);
		return "medical visit removed"+id;
		
	
		
	}
//put
	@Override
	public MedicaleVisit update(MedicaleVisit m) {
		MedicaleVisit mr=medicalvisitRepository.findById(m.getId()).orElse(null);
		mr.setDateEnd(m.getDateEnd());
		mr.setDateStart(m.getDateStart());
		mr.setDoctor(m.getDoctor());
		return medicalvisitRepository.save(mr);
		
		
	}

	
	

	
	

}
