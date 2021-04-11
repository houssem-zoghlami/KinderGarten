package tn.esprit.spring.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ICommentRepository;
import tn.esprit.spring.repository.IPublicationRepository;
import tn.esprit.spring.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor

@Service
public class CommentServiceImpl implements ICommentService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	IPublicationRepository publicationRepository;
	@Autowired
	ICommentRepository commentRepository;
	@Transactional(readOnly = true)
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();

		return userRepository.findByUsername(principal.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
	}


	@Override
	public Comment addComment(Comment c, int idP) {
		Publication pub=publicationRepository.findById(idP).orElse(null);
		c.setPublication(pub);
		c.setUser(getCurrentUser());
		c.setCreateDate(LocalDateTime.now());
		c.setText(c.getText());
		return  commentRepository.save(c);


	}

	@Override
	public String deleteComment(int id) throws Exception {
		commentRepository.deleteById(id);
		return "comment deleted successfully";

	}

	@Override
	public String updateComment(Comment comment, int id) throws Exception {
		comment=commentRepository.findById(id).orElse(null);
		comment.setUser(getCurrentUser());
		comment.setText(comment.getText());
		comment.setModifyDate(LocalDateTime.now());
		commentRepository.save(comment);
		return "comment updated successfully";



	}

	@Override
	public List<Comment> getAllComments() {
     return  (List<Comment>) commentRepository.findAll();
	}
	@Override
	public Optional<Comment> getCommentById(int id) {
		return commentRepository.findById(id);

	}

	@Override
	public int CountComments() {
		return 0;
	}

	@Override
	public List<Comment> getCommentsByUserId(int id) {
		return null;
	}

	@Override
	public int CountCommentsByUser(int id) {
		return 0;
	}

	@Override
	public List<Comment> getCommentsByPostId(int id) {
		return null;
	}

	@Override
	public int CountCommentsByPost(int id) {
		return 0;
	}

	@Override
	public List<Comment> searchComments(String text) {
		return null;
	}

}