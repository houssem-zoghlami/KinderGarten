package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {

	@Query("select n FROM Notification n where n.state_notification =:state_notification")
	public List<Notification> retrieveNotifByState(@Param("state_notification") boolean state_notification);
}
