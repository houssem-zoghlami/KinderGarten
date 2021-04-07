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

import tn.esprit.spring.entity.Coupon;
import tn.esprit.spring.service.ICouponService;

@RestController
public class CouponController {

	@Autowired
	ICouponService icouponservice;

	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/add-coupon/{event-id}
	@PostMapping(value = "/add-coupon/{event-id}")
	@ResponseBody
	public int adCoupon(@PathVariable("event-id") int eventId, @RequestBody Coupon coupon) {
		icouponservice.addCoupon(coupon,eventId);
		return 1;
	}

	// http://localhost:8082/springMVC/servlet/modify-Coupon/{coupon-id}
	@PutMapping("/modify-coupon/{coupon-id}")
	@ResponseBody
	public Coupon modifyCoupon(@PathVariable("coupon-id") int couponId, @RequestBody Coupon coupon) {
		return icouponservice.updateCoupon(couponId, coupon);
	}

	// http://localhost:8082/springMVC/servlet/delete-coupon/{coupon-id}
	@DeleteMapping("/delete-coupon/{coupon-id}")
	@ResponseBody
	public void removeCoupon(@PathVariable(name = "coupon-id") int couponId) {
		icouponservice.deleteCoupon(couponId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-coupons
	@GetMapping("/retrieve-all-coupons")
	@ResponseBody
	public List<Coupon> getCoupons() {
		List<Coupon> list = icouponservice.retrieveAllCoupons();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-coupon/{coupon-id}
	@GetMapping(path = "/retrieve-coupon/{coupon-id}")
	@ResponseBody
	public Coupon retrieveCoupon(@PathVariable("coupon-id") int couponId) {
		return icouponservice.retrieveCoupon(couponId);
	}

	///////////////////////////////////////////////////////////////// OTHERS////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/get-Coupons-Count/{id-event}
	@GetMapping("/get-Coupons-Count/{id-event}")
	@ResponseBody
	public int getEventsCount(@PathVariable("id-event") int id) {
		return icouponservice.CountCouponByEvent(id);
	}

	// http://localhost:8082/springMVC/servlet/add-coupon-nbrs/{id-coupon}	
	@PutMapping("/add-coupon-nbrs/{id-coupon}")
	@ResponseBody
	public int addCouponNbrs(@PathVariable("id-coupon") int id) {
		return icouponservice.addCouponNbrs(id);
	}
}
