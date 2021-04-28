package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.service.ActivityService;



@RestController
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	//post
	@PostMapping("/addactivity")
	public Activity addProduct(@RequestBody Activity activity){
		return activityService.saveActvity(activity);
		
	}
	
	@PostMapping("/addActivitys")
	public List<Activity> addProducts(@RequestBody List<Activity> activity){
		return activityService.saveActivitys(activity);
		
	}
	
	//get 
	@GetMapping("/activitys")
	 public List<Activity> findAllProducts(){
		 return  activityService.getActivity();
	 }
	@GetMapping("/activity/{id}")
	 public Activity findProductById(@PathVariable int id){
		 return activityService.getById(id);
	 }
	
	
	//put
	@PutMapping("/update")
	public Activity updateProduct(@RequestBody Activity activity){
		return activityService.updateActivity(activity);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id){
		return activityService.deleteActivity(id);
	}
	

}
