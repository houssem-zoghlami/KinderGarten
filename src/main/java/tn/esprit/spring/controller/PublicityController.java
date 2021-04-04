package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.service.PublicityServiceImpl;

import java.util.List;

@RequestMapping("/api/auth/Publication")

@RestController
public class PublicityController {

	@Autowired
	PublicityServiceImpl publicityService;

	// affichage des pub ( depend des prix des sponsoring)
	@GetMapping(value = "/retrieve-all-publicities")
	@ResponseBody
	public List<Publicity> getPublicities() {

		return publicityService.retrieveAllPublicitiesPub();

	}

	@PostMapping("/add-publicity")
	@ResponseBody
	public void addPublicity(@RequestBody Publicity p) {

		 publicityService.addPublicity(p);

	}



}
