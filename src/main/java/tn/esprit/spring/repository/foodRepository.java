package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.FoodCalories;

public interface foodRepository extends JpaRepository<FoodCalories, Long>{
	FoodCalories findById(long idfood);

	
	

}
