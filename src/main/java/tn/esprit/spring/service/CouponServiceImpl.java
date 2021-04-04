package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Coupon;
import tn.esprit.spring.repository.CouponRepository;

@Service
public class CouponServiceImpl implements ICouponService {

	@Autowired
	CouponRepository couponRepository;

	@Override
	public void addCoupon(Coupon coupon) {
		Date toDay = new Date();
		coupon.setDate_coupon(toDay);
		couponRepository.save(coupon);
	}

	@Override
	public void deleteCoupon(int id) {
		couponRepository.deleteById(id);

	}

	@Override
	public Coupon updateCoupon(int id, Coupon coupon) {
		Date toDay = new Date();
		// DateFormat shortDateFormat =
		// DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

		Coupon coupons = couponRepository.findById(id).orElse(null);
		if (coupon.getPrice() != 0) {
			coupons.setPrice(coupon.getPrice());
		}
		coupons.setDate_coupon(toDay);
		couponRepository.save(coupons);
		return coupons;
	}

	@Override
	public Coupon retrieveCoupon(int id) {
		Coupon coupon = couponRepository.findById(id).orElse(null);
		return coupon;
	}

	@Override
	public List<Coupon> retrieveAllCoupons() {
		List<Coupon> coupon = (List<Coupon>) couponRepository.findAll();
		return coupon;
	}

	@Override
	public Coupon getCouponByEventAndParent(int id_parent, int id_event) {
		Coupon coupon = couponRepository.getCouponByEventAndParent(id_parent, id_event);
		return coupon;
	}

	@Override
	public int CountCouponByEvent(int id_event) {
		int countCoupon = couponRepository.CountCouponByEvent(id_event);
		return countCoupon;
	}

}
