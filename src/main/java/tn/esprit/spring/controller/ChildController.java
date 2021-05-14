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

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.service.IChildService;


@RestController
public class ChildController {

	@Autowired
	IChildService ichildservice;
	
	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/add-child/{parent-id}
	@PostMapping(value = "/add-child/{parent-id}")
	@ResponseBody
	public void adChild(@PathVariable("parent-id") int parentId, @RequestBody Child child) {
		ichildservice.addChild(child, parentId);
	}

	// http://localhost:8082/springMVC/servlet/modify-child/{child-id}
	@PutMapping("/modify-child/{child-id}")
	@ResponseBody
	public Child modifyChild(@PathVariable("child-id") int childId, @RequestBody Child child) {
		return ichildservice.updateChild(childId, child);
	}

	// http://localhost:8082/springMVC/servlet/delete-child/{child-id}
	@DeleteMapping("/delete-child/{child-id}")
	@ResponseBody
	public void removeChild(@PathVariable(name = "child-id") int childId) {
		ichildservice.deleteChild(childId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-childs
	@GetMapping("/retrieve-all-childs")
	@ResponseBody
	public List<Child> getChilds() {
		List<Child> list = ichildservice.retrieveAllChild();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-child/{child-id}
	
	@GetMapping(path = "/retrieve-child/{child-id}")
	@ResponseBody
	public Child retrieveChild(@PathVariable("child-id") int childId) {
		return ichildservice.retrieveChild(childId);
	}
	
	// http://localhost:8082/springMVC/servlet/unsubscribeChild/{child-id}
	
	@PutMapping(path = "/unsubscribeChild/{child-id}")
	@ResponseBody
	public void unsubscribeChild(@PathVariable("child-id") int childId) {
		 ichildservice.unsubscribeChildren(childId);
	}

}
