package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Parent;

@Repository
public interface ParentRepository extends CrudRepository<Parent, Integer> {

	@Query("select p from Parent p where p.phone=:phone")
	public Parent findByPhone(@Param("phone") int phone);
	
	@Query("select p from Parent p where p.firstName=:firstName")
	public List<Parent> getAllParentByFirstName(@Param("firstName") String firstName);
	
	@Query("select p from Parent p where p.lastName=:lastName")
	public List<Parent> getAllParentByLastName(@Param("lastName") String lastName);
	
	@Query("select p from Parent p where p.address=:address")
	public List<Parent> getAllParentByAddress(@Param("address") String address);
	
	@Query("select p from Parent p where p.event=:event")
	public List<Parent> getAllParentByEvent(@Param("event") Event event);

}
