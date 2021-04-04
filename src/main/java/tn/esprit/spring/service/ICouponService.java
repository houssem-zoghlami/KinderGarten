package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Coupon;

public interface ICouponService {

	public void addCoupon(Coupon coupon);

	public void deleteCoupon(int id);

	public Coupon updateCoupon(int id, Coupon coupon);

	public Coupon retrieveCoupon(int id);

	public List<Coupon> retrieveAllCoupons();

	public Coupon getCouponByEventAndParent(int id_parent, int id_event);

	public int CountCouponByEvent(int id_event);
}
