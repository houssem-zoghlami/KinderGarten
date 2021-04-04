package tn.esprit.spring.service;

import tn.esprit.spring.entity.Rating;

import java.util.List;

public interface IRatingService {

	public String addRating(Rating r);

	public void deleteRating(int i);

	public int nbReview(int id);

	public List<Rating> retrieveAllReviews(int id);



	String updateRating(int id);

	public List<Rating> listLastReviews(int id);

}
