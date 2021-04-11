package tn.esprit.spring.service;


import tn.esprit.spring.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {

	public Comment  addComment(Comment c,int idP) ;
	public String deleteComment(int id) throws Exception;
	public String updateComment(Comment c, int id) throws Exception;
	public List<Comment> getAllComments();
	public Optional<Comment> getCommentById(int id);
	public int CountComments();
	public List<Comment> getCommentsByUserId(int id);
	public int CountCommentsByUser(int id);
	public List<Comment> getCommentsByPostId(int id);
	public int CountCommentsByPost(int id);
    public List<Comment> searchComments(String text);




}