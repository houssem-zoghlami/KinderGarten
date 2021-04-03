package tn.esprit.spring.service;

import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.User;

import java.util.List;


@Service
public class CommentServiceImpl implements ICommentService{


	@Override
	public String addComment(Comment c, int idP) throws Exception {
		return null;
	}

	@Override
	public String deleteComment(int id) throws Exception {
		return null;
	}

	@Override
	public String updateComment(Comment c, int id) throws Exception {
		return null;
	}

	@Override
	public List<Comment> getAllComments() {
		return null;
	}

	@Override
	public Comment getCommentById(int id) {
		return null;
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

	@Override
	public User currentUser() throws Exception {
		return null;
	}
}