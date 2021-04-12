package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.MedicalRec;

public interface MedRecRepository extends JpaRepository<MedicalRec, Integer> {
	

}
