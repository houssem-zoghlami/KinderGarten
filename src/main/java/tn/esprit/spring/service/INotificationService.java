package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Notification;

public interface INotificationService {

	public void addNotification(Notification notification);

	public void deleteNotification(int id);

	public void updateNotification(int id, String Subject, Date Duration);

	public Notification retrieveNotification(int id);

	public List<Notification> retrieveAllNotification();

	public List<Notification> retrieveNotifByState(boolean state_notification);

}
