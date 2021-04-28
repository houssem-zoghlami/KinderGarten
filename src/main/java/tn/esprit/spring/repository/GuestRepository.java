package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {	
	public List<Guest> getAllGuestByFirstName(@Param("firstName") String firstName);	
	public List<Guest> getAllGuestByLastName(@Param("lastName") String lastName);
	public List<Guest> getAllGuestByAddress(@Param("address") String address);
	

}