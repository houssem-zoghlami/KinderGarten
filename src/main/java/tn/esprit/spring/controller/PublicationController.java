package tn.esprit.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.Vote;
import tn.esprit.spring.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@PreAuthorize("hasRole('parent') or hasRole ('AdminGarten') or hasRole ('doctor') or hasRole ('Teacher')")

@RequestMapping("/api/Publication")

public class PublicationController {
    @Autowired
    IPublicationService publicationService;
    @Autowired
    IUploadFileService uploadFileService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    VoteService voteService;
    @Autowired
    ClaimServiceImpl claimService;


    @PostMapping("/addPublication")
    @ResponseBody
    public void addPublication(@RequestBody Publication publication) {
        publicationService.addPublication(publication);

    }
    @PostMapping("/assignAttachementToPost/{id}")
    public void assignAttachementToPost(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
        if (uploadFileService.addFile(file)) {
            publicationService.assignAttachementToPost(id, file);
        }
    }

//comment

    @PostMapping ("/addcomemntToPublication/{id}")
    public Comment addComment(@RequestBody Comment c,@PathVariable("id") int idP)  {

         return commentService.addComment(c,idP);
    }
    @DeleteMapping("/deleteComment/{idComment}")
    @ResponseBody
    public void deleteComment(@PathVariable("idComment") int commentId) throws Exception {

        commentService.deleteComment(commentId);
    }

    @PutMapping(value = "/updateComment/{idComment}")
    @ResponseBody
    public String updateComment(Comment comment, @PathVariable("idComment") int id) throws Exception {
        return  commentService.updateComment(comment,id);
    }
    @GetMapping(value = "/getcommentbyid/{idComment}")
    @ResponseBody
    public Optional<Comment> getCommentById(@PathVariable("idComment")int id){
        return commentService.getCommentById(id);

    }
    @GetMapping(value = "/getcomment")
        @ResponseBody
        public List<Comment> getAllComments(){
            return commentService.getAllComments();

    }
///reaction


    @PostMapping ("/addReactToPublication/{idp}")
    public void addReaction(@RequestBody Vote vote, @PathVariable("idp") int idp)  {

         voteService.addReaction(vote,idp);
    }
//claim

    @PostMapping ("/addClaim")
    public String addClaim(@RequestBody Claim claim)  {

        claimService.addClaim(claim);
        return "thank your for your reclamation ,we will respond you very soon as possible ";
    }



}



