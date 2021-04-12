package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Meeting_available;
import tn.esprit.spring.entity.Meeting_type;
import tn.esprit.spring.entity.Meeting_state;
import tn.esprit.spring.repository.Meeting_availableRepository;

@Service
public class Meeting_availableServiceImpl implements IMeeting_availableService {

	@Autowired
	Meeting_availableRepository meeting_availableRepository;

	@Override
	public void addMeeting(Meeting_available meeting) {
		meeting_availableRepository.save(meeting);
	}

	@Override
	public void deleteMeeting(int id) {
		meeting_availableRepository.deleteById(id);
	}

	@Override
	public Meeting_available updateMeeting(int id, Meeting_available meeting) {
		Meeting_available meetings = meeting_availableRepository.findById(id).orElse(null);
		if (meeting.getOpening() != null) {
			meetings.setOpening(meeting.getOpening());
		}
	
		if (meeting.getMeetingstate() != null) {
			meetings.setMeetingstate(meeting.getMeetingstate());
		}

		if (meeting.getClosing() != null) {
			meetings.setClosing(meeting.getClosing());
		}

		if (meeting.getMeetingtype() != null) {
			meetings.setMeetingtype(meeting.getMeetingtype());
		}

		meeting_availableRepository.save(meetings);
		return meetings;
	}

	@Override
	public Meeting_available retrieveMeeting(int id) {
		Meeting_available meeting = meeting_availableRepository.findById(id).orElse(null);
		return meeting;
	}

	@Override
	public List<Meeting_available> retrieveAllMeetings() {
		List<Meeting_available> meeting = (List<Meeting_available>) meeting_availableRepository.findAll();
		return meeting;
	}

	// research

	@Override
	public List<Meeting_available> getAllMeetingForToday() {
		List<Meeting_available> meeting = (List<Meeting_available>) meeting_availableRepository.getAllMeetingForToday();
		return meeting;
	}

	@Override
	public int countMeeting(int id) {
		int a = meeting_availableRepository.countMeeting(id);
		return a;
	}

	@Override
	public List<Meeting_available> getAllMeetingByState(Meeting_state meeting_state) {
		List<Meeting_available> meeting = (List<Meeting_available>) meeting_availableRepository.getAllMeetingByState(meeting_state);
		return meeting;
	}

	@Override
	public List<Meeting_available> getAllMeetingByType(Meeting_type meeting_type) {
		List<Meeting_available> meeting = (List<Meeting_available>) meeting_availableRepository.getAllMeetingByType(meeting_type);
		return meeting;
	}

}

