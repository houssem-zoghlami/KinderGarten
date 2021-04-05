package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.MedicaleVisit;

public interface IMedicalVisit {
	
	public void add(MedicaleVisit medicalVisitKinderGarten);

	public void remove(int id);

	public void update(MedicaleVisit m);

	public List<MedicaleVisit> getall();

	public MedicaleVisit getByid(int id);

}
