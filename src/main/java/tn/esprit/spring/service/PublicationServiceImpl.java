package tn.esprit.spring.service;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IPublicationRepository;
import tn.esprit.spring.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@Service
public class PublicationServiceImpl implements IPublicationService {

	@Autowired
	IPublicationRepository publicationRepository;
	@Autowired
	UserRepository userRepository;

	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();

		return userRepository.findByUsername(principal.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
	}


	@Override
	public void addPublication(Publication publication) {
		publication.setUser(getCurrentUser());
		publication.setDate(LocalDateTime.now());

		publicationRepository.save(publication);	
		
	}

	@Override
	public void deletePublication(int publicationId) {

		publicationRepository.deleteById(publicationId);
		
	}
	


	@Override
	public List<Publication> getAllPublication() {
		return (List<Publication>) publicationRepository.findAll();
	}

	@Override
	public void update(Publication publication) {
		publicationRepository.save(publication);
		
	}

	@Override
	public void assignAttachementToPost(int id, MultipartFile file) {
		Publication p = publicationRepository.findById(id).orElse(null);
		p.setUser(getCurrentUser());

		if (p!=null){
			p.setAttachment(file.getOriginalFilename());
			this.update(p);
		}
		
	}

	

}
