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

import tn.esprit.spring.entity.Meeting_available;
import tn.esprit.spring.entity.Meeting_state;
import tn.esprit.spring.entity.Meeting_type;
import tn.esprit.spring.service.IMeeting_availableService;

@RestController
public class Meeting_availableController {

	@Autowired
	IMeeting_availableService imeeting_availableservice;

	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/meeting
	@PostMapping(value = "/add-meeting")
	@ResponseBody
	public Meeting_available addMeeting(@RequestBody Meeting_available meeting) {
		imeeting_availableservice.addMeeting(meeting);
		return meeting;
	}

	// http://localhost:8082/springMVC/servlet/modify-meeting/{meeting-id}
	@PutMapping("/modify-meeting/{meeting-id}")
	@ResponseBody
	public Meeting_available modifyMeeting(@PathVariable("meeting-id") int meetingId, @RequestBody Meeting_available meeting) {
		return imeeting_availableservice.updateMeeting(meetingId, meeting);
	}

	// http://localhost:8082/springMVC/servlet/delete-meeting/{meeting-id}
	@DeleteMapping("/delete-meeting/{meeting-id}")
	@ResponseBody
	public void removeMeeting(@PathVariable(name = "meeting_-id") int meetingId) {
		imeeting_availableservice.deleteMeeting(meetingId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-meetings
	@GetMapping("/retrieve-all-meetings")
	@ResponseBody
	public List<Meeting_available> getMeetings() {
		List<Meeting_available> list = imeeting_availableservice.retrieveAllMeetings();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-meeting/{meeting-id}
	@GetMapping(path = "/retrieve-meeting/{meeting-id}")
	@ResponseBody
	public Meeting_available retrieveMeeting(@PathVariable("meeting-id") int meetingId) {
		return imeeting_availableservice.retrieveMeeting(meetingId);
	}

	///////////////////////////////////////////////////////////////// OTHERS////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/get-meetings-By-Type/{meeting-type}
	@GetMapping("/get-Meetings-By-Type/{meeting-type}")
	@ResponseBody
	public List<Meeting_available> getMeetingsByType(@PathVariable("meeting-type") Meeting_type meeting_type) {
		List<Meeting_available> list = imeeting_availableservice.getAllMeetingByType(meeting_type);
		return list;
	}

	// http://localhost:8082/springMVC/servlet/get-Meetings-By-State/{meeting-state}
	@GetMapping("/get-Meetings-By-State/{meeting-state}")
	@ResponseBody
	public List<Meeting_available> getMeetingsByState(@PathVariable("Event-Activity") Meeting_state meeting_state) {
		List<Meeting_available> list = imeeting_availableservice.getAllMeetingByState(meeting_state);
		return list;
	}

	// http://localhost:8082/springMVC/servlet/get-Meetings-For-Today
	@GetMapping("/get-Meetings-For-Today")
	@ResponseBody
	public List<Meeting_available> getMeetingsForToday() {
		List<Meeting_available> list = imeeting_availableservice.getAllMeetingForToday();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/get-Meetings-Count/{id-meeting}
	@GetMapping("/get-Meetings-Count/{id-meeting}")
	@ResponseBody
	public int getMeetingsCount(@PathVariable("id-meeting") int id) {

		return imeeting_availableservice.countMeeting(id);
	}

}
