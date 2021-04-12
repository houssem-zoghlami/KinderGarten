package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Meeting_available;
import tn.esprit.spring.entity.Meeting_type;
import tn.esprit.spring.entity.Meeting_state;

public interface IMeeting_availableService {

	public void addMeeting(Meeting_available meeting);

	public void deleteMeeting(int id);

	public Meeting_available updateMeeting(int id, Meeting_available meeting);

	public Meeting_available retrieveMeeting(int id);

	public List<Meeting_available> retrieveAllMeetings();

	public List<Meeting_available> getAllMeetingForToday();

	public int countMeeting(int id);

	public List<Meeting_available> getAllMeetingByState(Meeting_state meeting_state);

	public List<Meeting_available> getAllMeetingByType(Meeting_type meeting_type);


}
