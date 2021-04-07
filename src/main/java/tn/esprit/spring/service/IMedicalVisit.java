package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.MedicaleVisit;

public interface IMedicalVisit {
	
	public MedicaleVisit save(MedicaleVisit m);
	public List<MedicaleVisit> saveall(List<MedicaleVisit> m);

	public String remove(int id);

	public MedicaleVisit update(MedicaleVisit m);

	public List<MedicaleVisit> getall();

	public MedicaleVisit getByid(int id);

}
