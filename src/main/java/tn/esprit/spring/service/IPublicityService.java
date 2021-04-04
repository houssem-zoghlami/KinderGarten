package tn.esprit.spring.service;

import tn.esprit.spring.entity.Publicity;

import java.util.List;


public interface IPublicityService {
	List<Publicity> retrieveAllPublicities(Long id);
	List<Publicity> retrieveAllPublicitiesPub();
	void addPublicity(Publicity p) ;
	void deletePublicity(int i);
    public void updatePublicity();
	Publicity retrievePublicity(int idUser);
    void updateRating();
    int addOrUpdatePub(Publicity pub);
    byte[] findImage(int imageId);
	float getRating(int id);
	List<Publicity> searchPub(String msg);
	


}
