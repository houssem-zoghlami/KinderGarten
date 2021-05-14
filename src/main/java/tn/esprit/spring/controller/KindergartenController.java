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

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.service.IKindergartenService;

@RestController
public class KindergartenController {
	
	@Autowired
	IKindergartenService ikindergartenService;
	
	// http://localhost:8082/springMVC/servlet/add-kindergarten
		@PostMapping(value = "/add-kindergarten")
		@ResponseBody
		public Kindergarten adKindergarten(@RequestBody Kindergarten kindergarten) {
			ikindergartenService.addKindergarten(kindergarten);
			return kindergarten;
		}

		// http://localhost:8082/springMVC/servlet/modify-kindergarten/{kindergarten-id}
		@PutMapping("/modify-kindergarten/{kindergarten-id}")
		@ResponseBody
		public Kindergarten modifyKindergarten(@PathVariable("kindergarten-id") int kindergartenId, @RequestBody Kindergarten kindergarten) {
			return ikindergartenService.updateKindergarten(kindergartenId, kindergarten);
		}

		// http://localhost:8082/springMVC/servlet/delete-kindergarten/{kindergarten-id}
		@DeleteMapping("/delete-kindergarten/{kindergarten-id}")
		@ResponseBody
		public void removekindergarten(@PathVariable(name = "coupon-id") int kindergartenId) {
			ikindergartenService.deleteKindergarten(kindergartenId);
		}

		// http://localhost:8082/springMVC/servlet/retrieve-all-kindergartens
		@GetMapping("/retrieve-all-kindergartens")
		@ResponseBody
		public List<Kindergarten> getCoupons() {
			List<Kindergarten> list = ikindergartenService.retrieveAllKindergartens();
			return list;
		}

		// http://localhost:8082/springMVC/servlet/retrieve-kindergarten/{kindergarten-id}
		@GetMapping(path = "/retrieve-kindergarten/{kindergarten-id}")
		@ResponseBody
		public Kindergarten retrieveCoupon(@PathVariable("kindergarten-id") int kindergartenId) {
			return ikindergartenService.retrieveKindergarten(kindergartenId);
		}

}
