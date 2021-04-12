package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Guest;

public interface IGuestService {

	public void addGuest(Guest guest);

	public void deleteGuest(int id);

	public Guest updateGuest(int id, Guest guest);

	public Guest retrieveGuest(int id);
	
	public List<Guest> retrieveAllGuests();
	
	public List<Guest> getAllGuestByAddress(@Param("address") String address);
	
	public List<Guest> getAllGuestByLastName(@Param("lastName") String lastName);
	
	public List<Guest> getAllGuestByFirstName(@Param("firstName") String firstName);
	
}
