package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vote;
import tn.esprit.spring.repository.IPublicationRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VoteRepository;


@Service
@AllArgsConstructor
public class VoteService implements IVoteService{
    @Autowired
    IPublicationRepository publicationRepository;
    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepository userRepository;

    private static Logger log = LoggerFactory.getLogger(VoteService.class);
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();

        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }


    @Override
    public void addReaction(Vote vote,int idp) {

        Publication publication = publicationRepository.findById(idp).orElseThrow();

        vote.setUser(getCurrentUser());
        vote.setPublication(publication);


           publication.setVoteCount(publication.getVoteCount() + 1);
        if(vote.getUser()==getCurrentUser()) {
            voteRepository.save(vote);
            publicationRepository.save(publication);
       }else
       {
           log.debug("error");
       }


    }
}
