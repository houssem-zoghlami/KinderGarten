package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.MedicalRec;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
	
	@Query("select e.MedicalRec from Child e " //e.MedicalRec
			 +"join e.kindergarten t "
			 +"where t.id=:id")
	  public List<MedicalRec> getAllmedicalrecdbykindergartene(@Param("id") int id);

}
