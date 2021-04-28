package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.MedicalRec;
import tn.esprit.spring.entity.Parent;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
	
	@Query("select e.MedicalRec from Child e join e.kindergarten t where t.id=:id")
	  public List<MedicalRec> getAllmedicalrecdbykindergartene(@Param("id") int id);
	
	@Query("select c from Child c where c.kindergarten.id=:id")
	public List<Child> getAllChildByKindergarten(@Param("id") int id);
	
	@Query("select c.parent from Child c where c.kindergarten.id=:id")
	public List<Parent> getAllParent(@Param("id") int id);
	
	@Query("select c.parent from Child c where c.subscribe = false")
	public List<Parent> getAllParentOfChildNoSubscribe();

}
