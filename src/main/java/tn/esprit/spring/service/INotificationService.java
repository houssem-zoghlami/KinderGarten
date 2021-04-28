package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Parent;

public interface INotificationService {

	public void addNotification(Notification notification);

	public void deleteNotification(int id);

	public void updateNotification(int id, String Subject, Date Duration);

	public Notification retrieveNotification(int id);

	public List<Notification> retrieveAllNotification();

	public List<Notification> retrieveNotifByRecipient(String recipient);

	public void sendMail(Notification notification) throws IOException;

	public void SendNotificationForAllParent() throws IOException;

	public List<Kindergarten> takekindergartenByParent(Parent parent);

	public ByteArrayInputStream ListKindergartenToPdf(List<Kindergarten> kindergartens);

}
