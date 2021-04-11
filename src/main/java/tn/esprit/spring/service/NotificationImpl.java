package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.repository.NotificationRepository;

public class NotificationImpl implements INotificationService {

	@Autowired
	NotificationRepository notificationRepository;

	@Override
	public void addNotification(Notification notification) {
		notificationRepository.save(notification);

	}

	@Override
	public void deleteNotification(int id) {
		notificationRepository.deleteById(id);
	}

	@Override
	public void updateNotification(int id, String Subject, Date Duration) {
		Notification notification = notificationRepository.findById(id).orElse(null);
		notification.setDuration(Duration);
		notification.setSubject(Subject);
		notificationRepository.save(notification);
	}

	@Override
	public Notification retrieveNotification(int id) {
		Notification notification = notificationRepository.findById(id).orElse(null);
		return notification;
	}

	@Override
	public List<Notification> retrieveAllNotification() {
		List<Notification> notification = (List<Notification>) notificationRepository.findAll();
		return notification;
	}

	@Override
	public List<Notification> retrieveNotifByState(boolean state_notification) {
		List<Notification> notification = (List<Notification>) notificationRepository
				.retrieveNotifByState(state_notification);
		return notification;
	}

}
