package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Publicity;

public interface PublicityRepository extends JpaRepository<Publicity, Integer> {
}