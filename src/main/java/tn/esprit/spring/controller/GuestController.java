package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Guest;
import tn.esprit.spring.service.IGuestService;

@RestController
public class GuestController {

	@Autowired
	IGuestService iguestservice;

	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/add-guest
	@PostMapping(value = "/add-guest")
	@ResponseBody
	public Guest addGuest(@RequestBody Guest guest) {
		iguestservice.addGuest(guest);
		return guest;
	}

	// http://localhost:8082/springMVC/servlet/modify-guest/{guest-id}
	@PutMapping("/modify-guest/{guest-id}")
	@ResponseBody
	public Guest modifyGuest(@PathVariable("guest-id") int guestId, @RequestBody Guest guest) {
		return iguestservice.updateGuest(guestId, guest);
	}

	// http://localhost:8082/springMVC/servlet/delete-guest/{guest-id}
	@DeleteMapping("/delete-guest/{guest-id}")
	@ResponseBody
	public void removeGuest(@PathVariable(name = "guest-id") int guestId) {
		iguestservice.deleteGuest(guestId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-guests
	@GetMapping("/retrieve-all-guests")
	@ResponseBody
	public List<Guest> getGuests() {
		List<Guest> list = iguestservice.retrieveAllGuests();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-guest/{guest-id}
	@GetMapping(path = "/retrieve-guest/{guest-id}")
	@ResponseBody
	public Guest retrieveGuest(@PathVariable("guest-id") int guestId) {
		return iguestservice.retrieveGuest(guestId);
	}

}
