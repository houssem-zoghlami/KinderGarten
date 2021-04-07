package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.repository.IActivityRepository;

@Service
public class ActivityService {
	@Autowired
	private IActivityRepository iActivityRepository;
	
	//post
	public Activity saveActvity(Activity activity){ //for one activity
		return iActivityRepository.save(activity);
	}
	
	public List<Activity> saveActivitys(List<Activity> activity){ //save bunch of activitys
		return iActivityRepository.saveAll(activity);
		
	}

	//get
	
	public List<Activity> getActivity(){ // get all activity
		return  iActivityRepository.findAll();
	}
	
	public Activity getActivityByid(int id){ //get activity by id
		return iActivityRepository.findById(id).orElse(null);
		
	}
	
	public Activity getActivityByName(String name){ //get activity by name
		return iActivityRepository.findByName(name);
		
	}
	
	//put
	public String deleteActivity(int id){
		 iActivityRepository.deleteById(id);
		 return "Activity removed " + id;
	}
	
	//update
public Activity  updateActivity(Activity activity){
		Activity existingActivity = iActivityRepository.findById(activity.getId()).orElse(null);
	existingActivity.setName(activity.getName());
		existingActivity.setActivityType(activity.getActivityType());
		existingActivity.setActivityDate(activity.getActivityDate());
		return iActivityRepository.save(existingActivity);
		
	}
}
