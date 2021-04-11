package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Kindergarten;

public interface IKindergartenService {
	public void addKindergarten(Kindergarten kindergarten);

	public void deleteKindergarten(int id);

	public Kindergarten updateKindergarten(int id, Kindergarten kindergarten);

	public Kindergarten retrieveKindergarten(int id);

	public List<Kindergarten> retrieveAllKindergartens();

}
