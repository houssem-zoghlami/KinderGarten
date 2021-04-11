package tn.esprit.spring.service;

import tn.esprit.spring.entity.Claim;

import java.util.List;

public interface IClaimService {
	
	public String addClaim (Claim c);
	
	public void deleteClaim(int id);
	
	public List<Claim> getAllClaims();
	
	public String ChangeStateClaim (int claim);

	public List<Claim> SearchClaimByType(String Type);

	public Claim getClaimsById(int id);
	



}