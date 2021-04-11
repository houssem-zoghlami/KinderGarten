package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Coupon;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Integer> {
	
	@Query(value = "select count(*) from Coupon c where c.event.id_event=:id_event")
	public int CountCouponByEvent(@Param("id_event") int id_event);

}
