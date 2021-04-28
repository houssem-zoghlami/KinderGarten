package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.repository.IemployeeRepository;


@Service

public class EmployeeService {
	
	@Autowired
	IemployeeRepository iemployeeRepository;
	
	public long ajouterEmployee(Employee u){
		iemployeeRepository.save(u); 
		
		return u.getEmployee_id();	
	}

	public void deleteEmployee(int employee_id) {
		iemployeeRepository.deleteById(employee_id);

	}


	public void updateEmployee(int employee_id, String employee_name, int age,tn.esprit.spring.entity.Job job) {
		// TODO Auto-generated method stub
		Employee u = iemployeeRepository.findById(employee_id).orElse(null);
		u.setEmployeename(employee_name);
		u.setAge(age);
		u.setJob(job);
		iemployeeRepository.save(u);
	} 
	    
	}
