package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.FoodCalories;
import tn.esprit.spring.entity.Kindergarten;

@Repository
public interface KindergartenRepository extends CrudRepository<Kindergarten, Integer> {

}
