package tn.esprit.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicityServiceImpl implements IPublicityService {
	@Autowired
	private tn.esprit.spring.repository.PublicityRepository PublicityRepository;
	@Autowired
	UserRepository userRepository;


	private static final Logger L = (Logger) LogManager.getLogger(PublicityServiceImpl.class);
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();

		return userRepository.findByUsername(principal.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
	}


	@Override
	public List<Publicity> retrieveAllPublicities(Long id) {
		return null;
	}

	@Override
	public List<Publicity> retrieveAllPublicitiesPub() {
		return null;
	}

	@Override
	public void addPublicity(Publicity p) {
		p.setUser(getCurrentUser());
		p.setProductName(p.getProductName());
		p.setCategory(p.getCategory());
		p.setMarque(p.getMarque());
		PublicityRepository.save(p);
	}

	@Override
	public void deletePublicity(int i) {
		PublicityRepository.deleteById(i);

	}

	/*
	 * @Override public List<User> retrieveAllUsers() { List<User> users =
	 * (List<User>) UserRepository.findAll(); for (User user : users) {
	 * L.info("user +++ : " + user); } return users; }
	 */

	@Override
	@Transactional
	// @Scheduled(cron="*/10 * * * * ?")
	public void updatePublicity() {
		System.out.println("manel");
		List<Publicity> pubs = new ArrayList<Publicity>();
		pubs = PublicityRepository.findAll();
		for (Publicity p : pubs) {
			if (p.getPriceSponsoring() > 200) {
				p.setPriceSponsoring(p.getPriceSponsoring() - 200);

				PublicityRepository.save(p);
				System.out.println(p.getPriceSponsoring());
			}
		}

	}

	@Override
	public Publicity retrievePublicity(int idUser) {
		return null;
	}

	@Override
	public void updateRating() {

	}

	@Override
	public int addOrUpdatePub(Publicity pub) {
		return 0;
	}

	@Override
	public byte[] findImage(int imageId) {
		return new byte[0];
	}

	@Override
	public float getRating(int id) {
		return 0;
	}

	@Override
	public List<Publicity> searchPub(String msg) {
		return null;
	}


}