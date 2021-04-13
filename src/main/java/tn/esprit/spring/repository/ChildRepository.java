package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Parent;

@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {
	
	@Query("select c from Child c where c.kindergarten.id=:id")
	public List<Child> getAllChildByKindergarten(@Param("id") int id);
	
	@Query("select c.parent from Child c where c.kindergarten.id=:id")
	public List<Parent> getAllParent(@Param("id") int id);
	
	@Query("select c.parent from Child c where c.subscribe = false")
	public List<Parent> getAllParentOfChildNoSubscribe();
}
