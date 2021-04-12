package tn.esprit.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.service.IKindergartenService;
import tn.esprit.spring.service.INotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	INotificationService inotificationService;
	
	@Autowired
	IKindergartenService ikindergartenService;
	
	// http://localhost:8082/springMVC/servlet/add-notification
	@PostMapping(value = "/add-notification")
	@ResponseBody
	public Notification adnotification(@RequestBody Notification notification) {
		inotificationService.addNotification(notification);
		return notification;
	}
	
	// http://localhost:8082/springMVC/servlet/delete-Notification/{Notification-id}
	@DeleteMapping("/delete-Notification/{Notification-id}")
	@ResponseBody
	public void removeNotification(@PathVariable(name = "Notification-id") int id) {
		inotificationService.deleteNotification(id);
	}
	
	// http://localhost:8082/springMVC/servlet/SendMail
	@PostMapping(value = "/SendMail")
	@ResponseBody
	public String SendMail(@RequestBody Notification notification) throws IOException {
		inotificationService.sendMail(notification);
		return "Done";
	}
	
	
	
	// http://localhost:8082/springMVC/servlet/SendMailForParents
	@PostMapping(value = "/SendMailForParents")
	@ResponseBody
	public String SendMailForParents() throws IOException {
		inotificationService.SendNotificationForAllParent();
		return "Done";
	}

}
