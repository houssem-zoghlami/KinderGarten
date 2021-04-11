package tn.esprit.spring.service;

import tn.esprit.spring.entity.Vote;

public interface IVoteService {
    public void addReaction(Vote vote, int idp);

}
