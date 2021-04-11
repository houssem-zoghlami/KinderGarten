package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Activity;


public interface IActivityRepository extends JpaRepository<Activity, Integer> {

	
	Activity findById(int id);
}
