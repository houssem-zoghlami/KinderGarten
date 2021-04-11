package tn.esprit.spring.service;
import tn.esprit.spring.entity.Job;

import tn.esprit.spring.entity.Employee;



public interface IEmployeeService {
	public long ajouterEmployee(Employee u); 
	public void deleteEmployee(int employee_id);
	public void updateEmployee( int employee_id, String employee_name, int age,Job job);
}
