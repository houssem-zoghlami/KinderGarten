package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vote;

import java.util.Optional;


@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    Optional<Vote> findTopByPublicationAndUserOrderByVoteIdDesc(Publication publication, User currentUser);
}
