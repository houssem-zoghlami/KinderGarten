package tn.esprit.spring.service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.Publication;

import java.util.List;

public interface IPublicationService {
		public void addPublication(Publication publication); 
		public void deletePublication (int publicationId);
		public void update(Publication publication );
		public void assignAttachementToPost(int id , MultipartFile file);
		public List<Publication> getAllPublication();
		

		
}
