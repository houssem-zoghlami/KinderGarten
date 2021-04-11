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

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.service.IParentService;

@RestController
public class ParentController {

	@Autowired
	IParentService iparentservice;

	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/add-parent
	@PostMapping(value = "/add-parent")
	@ResponseBody
	public Parent adParent(@RequestBody Parent parent) {

		iparentservice.addParent(parent);
		return parent;
	}

	// http://localhost:8082/springMVC/servlet/modify-parent/{parent-id}
	@PutMapping("/modify-parent/{parent-id}")
	@ResponseBody
	public Parent modifyParent(@PathVariable("parent-id") int parentId, @RequestBody Parent parent) {
		return iparentservice.updateParent(parentId, parent);
	}

	// http://localhost:8082/springMVC/servlet/delete-parent/{parent-id}
	@DeleteMapping("/delete-parent/{parent-id}")
	@ResponseBody
	public void removeParent(@PathVariable(name = "parent-id") int parentId) {
		iparentservice.deleteParent(parentId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-parents
	@GetMapping("/retrieve-all-parents")
	@ResponseBody
	public List<Parent> getParents() {
		List<Parent> list = iparentservice.retrieveAllParents();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-parent/{parent-id}
	@GetMapping(path = "/retrieve-parent/{parent-id}")
	@ResponseBody
	public Parent retrieveParent(@PathVariable("parent-id") int parentId) {
		return iparentservice.retrieveParent(parentId);
	}

	///////////////////////////////////////////////////////////////// OTHERS////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/participate-Parent-In-Event/{parent-id}/{event-id}
	@PutMapping(path = "/participate-Parent-In-Event/{parent-id}/{event-id}")
	@ResponseBody
	public int participateParentInEvent(@PathVariable("parent-id") int parentId,
			@PathVariable("event-id") int eventId) {
		return iparentservice.participateParentInEvent(parentId, eventId);
	}

	// http://localhost:8082/springMVC/servlet/unparticipate-Parent-In-Event/{parent-id}/{event-id}
	@DeleteMapping(path = "/unparticipate-Parent-In-Event/{parent-id}/{event-id}")
	@ResponseBody
	public int unparticipateParentInEvent(@PathVariable("parent-id") int parentId,
			@PathVariable("event-id") int eventId) {
		return iparentservice.unparticipateParentInEvent(parentId, eventId);
	}
	

	// http://localhost:8082/springMVC/servlet/join-kindergarten/{parent-id}/{event-id}/{month-join}
	@PostMapping(path = "/join-kindergarten/{kindergarten-id}/{parent-id}/{month-join}/{child-id}")
	@ResponseBody
	public int joinkindergarten(@PathVariable("parent-id") int parentId,
			@PathVariable("kindergarten-id") int kindergartenId, @PathVariable("month-join") int monthjoin,@PathVariable("child-id") int childid) {
		return iparentservice.joinKindergarten(parentId, kindergartenId, monthjoin,childid);
	}



}
