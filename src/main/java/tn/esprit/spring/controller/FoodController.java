package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.foodService;

@RestController
public class FoodController {
	@Autowired
	foodService ser;
	
	
	
	public String  affectfoodbyidmedrec(long food) throws ParseException, IOException{
		ser.affectmedicalrectofood(1,food);       
        
		return "Food have been successfully affected to childs";
	}
	
	@PostMapping("foodadd")
	public void add(@RequestBody int id,@RequestBody int foodid) throws Exception{
		ser.affectmedicalrectofood(id, foodid);
	}
	

}
