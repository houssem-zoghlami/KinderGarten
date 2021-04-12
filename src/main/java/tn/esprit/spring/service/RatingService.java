package tn.esprit.spring.service;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PublicityRepository;
import tn.esprit.spring.repository.RatingRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Service
public class RatingService implements IRatingService {
	@Autowired
	RatingRepository RatingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PublicityRepository publicityRepository;

	private static final Logger L = (Logger) LogManager.getLogger(PublicationServiceImpl.class);

	public List<Rating> retrieveAllRating() {
		List<Rating> ratings = (List<Rating>) RatingRepository.findAll();
		for (Rating rating : ratings) {
			L.info("user +++ : " + rating);
		}
		return ratings;

	}
	@Transactional(readOnly = true)
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();

		return userRepository.findByUsername(principal.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
	}


	public String addRating(Rating r ,int id) throws Exception{
		Publicity p = publicityRepository.findById(id).orElse(null);
		r.setUser(getCurrentUser());
		r.setPublicity(p);
		r.setDateRating(new Date());
		if (r.getNote()>5  ||r.getNote()<0 )

		{

			return "il faut saisir une note comprise entre 0 et 5 ";

		}

		RatingRepository.save(r);
		return "note enregistré";
	}

	@Override
	public String updateRating(int id) {

		Rating rating = new Rating();

		rating = RatingRepository.findById(id);

		//rating.setNote(note);



		// rating.setNote(5);
		rating.setDateRating(new Date());
		RatingRepository.save(rating);

		return "note enregistré";
	}


	@Override
	public void deleteRating(int i) {
		RatingRepository.deleteById(i);

	}

	@Override
	public int nbReview(int id) {

		return RatingRepository.nbreviews(id);
	}

	@Override
	public List<Rating> retrieveAllReviews(int id) {

		return RatingRepository.listReviews(id);

	}
	
	@Override
	public List<Rating> listLastReviews(int id) {

		return RatingRepository.listLastReviews(id);

	}

}
