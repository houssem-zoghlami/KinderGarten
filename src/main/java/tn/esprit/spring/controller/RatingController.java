package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.service.RatingService;

import java.util.List;
@RequestMapping("/api/auth/Publication")

//commit
@RestController
public class RatingController {
	@Autowired
	RatingService ratingService;
	
	@PostMapping("/add-rating/{id}")
	public String addRating(Rating r,@PathVariable("id") int id) throws Exception {
	return ratingService.addRating(r,id);
	 }
	
	@GetMapping(value ="/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() {
	
	return ratingService.retrieveAllRating();
    
} 
	/*@GetMapping("/editNote/{id}&{note}")
public String updateNote(@PathVariable("id") int id,@PathVariable("note") int note){
		return ratingService.updateRating(id, note);
	
}
	*/
	@DeleteMapping("/remove-rating/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") int id) {
	ratingService.deleteRating(id);
	 }
	
	
	@GetMapping(value = "retrieve-all-ratingParPub/{id}")
	@ResponseBody
	public List<Rating> getPublicitiesParPub(@PathVariable("id") int id) {

		return ratingService. retrieveAllReviews(id);

	}

}





