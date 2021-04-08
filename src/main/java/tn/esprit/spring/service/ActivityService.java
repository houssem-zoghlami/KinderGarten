package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.repository.IActivityRepository;

@Service
public class ActivityService implements IActivityService{
	@Autowired
	private IActivityRepository iActivityRepository;
	
	//post
	@Override
	public Activity saveActvity(Activity activity){ //for one activity
		return iActivityRepository.save(activity);
	}
	@Override
	public List<Activity> saveActivitys(List<Activity> activity){ //save bunch of activitys
		return iActivityRepository.saveAll(activity);
		
	}

	//get
	@Override
	public List<Activity> getActivity(){ // get all activity
		return  iActivityRepository.findAll();
	}
	@Override
	public Activity getById(int id){ //get activity by id
		return iActivityRepository.findById(id);
		
	}
	

	//put
	@Override
	public String deleteActivity(int id){
		 iActivityRepository.deleteById(id);
		 return "Activity removed " + id;
	}
	
	//update
	@Override
public Activity  updateActivity(Activity activity){
		Activity existingActivity = iActivityRepository.findById(activity.getId());
	existingActivity.setName(activity.getName());
		existingActivity.setActivityType(activity.getActivityType());
		existingActivity.setActivityDate(activity.getActivityDate());
		return iActivityRepository.save(existingActivity);
		
	}
}
