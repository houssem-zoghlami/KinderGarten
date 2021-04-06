package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {
	
	@Query("select g from Parent g where g.firstName=:firstName")
	public List<Guest> getAllGuestByFirstName(@Param("firstName") String firstName);
	
	@Query("select g from Parent p where g.lastName=:lastName")
	public List<Guest> getAllGuestByLastName(@Param("lastName") String lastName);
	
	@Query("select g from Parent g where g.address=:address")
	public List<Guest> getAllGuestByAddress(@Param("address") String address);
	

}