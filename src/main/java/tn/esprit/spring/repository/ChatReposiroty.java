package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Chat;



@Repository
public interface ChatReposiroty extends JpaRepository<Chat, Integer> {

	Chat findById(int id);

	
	


	//@Query("select new Chat(c.id, c.message) from Chat c")
	//List<Chat> displayAll();

	
}
