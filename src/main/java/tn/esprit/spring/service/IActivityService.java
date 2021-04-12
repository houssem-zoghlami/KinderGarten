package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Activity;

public interface IActivityService {
	public Activity saveActvity(Activity activity);
	public List<Activity> saveActivitys(List<Activity> activity);
	public List<Activity> getActivity();
	public Activity getById(int id);
	
	public String deleteActivity(int id);
	public Activity  updateActivity(Activity activity);

}
