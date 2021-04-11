package tn.esprit.spring.service;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.StateClaim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IClaimRepository;
import tn.esprit.spring.repository.UserRepository;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor

@Service
public class ClaimServiceImpl implements IClaimService {
	
	@Autowired
	IClaimRepository iClaimRepository;
	
	@Autowired
	UserRepository userRepository;

	@Transactional(readOnly = true)
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();

		return userRepository.findByUsername(principal.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
	}


	@Override
	public List<Claim> getAllClaims() {
		
	List<Claim> claims = (List<Claim>) iClaimRepository.findAll();
	
	return claims;
		
	}

	@Override
	public String ChangeStateClaim(int IdClaim)
	{

		Claim c = iClaimRepository.findById(IdClaim).get();
		
	
		
		if (c.getState().equals(StateClaim.InProgress.toString()))
			
		{
			c.setState(StateClaim.closing.toString());
			iClaimRepository.save(c);
			return "your claim " +IdClaim+" your claim is treated successfully !! " +
					"thank you for your Reactivity  " ;
	
		}
			
		else return "there is an error ";
	}

	@Override
	public List<Claim> SearchClaimByType(String Type) {
		
		return (List<Claim>) iClaimRepository.searchClaimByType(Type);
	}




	
	public Claim getClaimsById(int id)
	{
		return iClaimRepository.findById(id).get();
	}



	@Override
	public void deleteClaim(int id) {
		Claim c = iClaimRepository.findById(id).get();
		iClaimRepository.delete(c);
	}

	@Override
	public String addClaim(Claim c)
	{
		c.setUser(getCurrentUser());
		c.setCreated(Instant.now());
		c.setState(StateClaim.InProgress.toString());
		 iClaimRepository.save(c).getId();
		 return "thank your for your reclamation ,we will respond you very soon as possible";

	}

	
	
}
