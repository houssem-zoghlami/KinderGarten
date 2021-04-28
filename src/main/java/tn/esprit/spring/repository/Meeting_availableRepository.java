package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Meeting_available;
import tn.esprit.spring.entity.Meeting_type;
import tn.esprit.spring.entity.Meeting_state;

@Repository
public interface Meeting_availableRepository extends CrudRepository<Meeting_available, Integer> {

	
	@Query("select m from Meeting_available m where m.meetingtype=:meeting_type")
	public List<Meeting_available> getAllMeetingByType(@Param("meeting_type") Meeting_type meeting_type);

	@Query("select m from Meeting_available m where m.meetingstate=:meeting_state")
	public List<Meeting_available> getAllMeetingByState(@Param("meeting_state") Meeting_state meeting_state);

	@Query("SELECT count(meeting) FROM Meeting_available m where m.id_meeting =:id")
	public int countMeeting(@Param("id") int id);

	@Query("SELECT m from Meeting_available m where m.opening = CURRENT_DATE()")
	public List<Meeting_available> getAllMeetingForToday();

}
