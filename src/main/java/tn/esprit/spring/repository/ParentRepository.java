package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer> {

}
