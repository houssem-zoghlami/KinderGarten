package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Guest;
import tn.esprit.spring.repository.GuestRepository;

@Service
public class GuestServiceImpl implements IGuestService {

	@Autowired
	GuestRepository guestRepository;

	@Override
	public void addGuest(Guest guest) {
		guestRepository.save(guest);

	}

	@Override
	public void deleteGuest(int id) {
		guestRepository.deleteById(id);
	}

	@Override
	public Guest updateGuest(int id, Guest guest) {

		Guest guests = guestRepository.findById(id).orElse(null);
		
		if (guest.getAddress() != null) {
			guests.setAddress(guest.getAddress());
		}
		if (guest.getFirstName() != null) {
			guests.setFirstName(guest.getFirstName());
		}
		if (guest.getLastName() != null) {
			guests.setLastName(guest.getLastName());
		}
		guestRepository.save(guests);
		return guests;
	}

	@Override
	public Guest retrieveGuest(int id) {
		Guest guest = guestRepository.findById(id).orElse(null);
		return guest;
	}

	@Override
	public List<Guest> retrieveAllGuests() {
		List<Guest> parent = (List<Guest>) guestRepository.findAll();
		return parent;
	}


	@Override
	public List<Guest> getAllGuestByAddress(String address) {
		List<Guest> parent = (List<Guest>) guestRepository.getAllGuestByAddress(address);
		return parent;
	}

	@Override
	public List<Guest> getAllGuestByLastName(String lastName) {
		List<Guest> parent = (List<Guest>) guestRepository.getAllGuestByLastName(lastName);
		return parent;
	}

	@Override
	public List<Guest> getAllGuestByFirstName(String firstName) {
		List<Guest> parent = (List<Guest>) guestRepository.getAllGuestByFirstName(firstName);
		return parent;
	}

}