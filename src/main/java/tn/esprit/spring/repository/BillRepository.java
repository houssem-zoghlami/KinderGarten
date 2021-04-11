package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {

	@Query("select b from Bill b where b.date_bill=:date_bill")
	public List<Bill> getAllBillByDate(@Param("date_bill") Date date);

}
