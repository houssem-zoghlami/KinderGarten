package tn.esprit.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ClaimServiceImpl;
import tn.esprit.spring.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@AllArgsConstructor
@PreAuthorize("hasRole('Admin')")


public class AdminController {

    @Autowired
    UserServiceImpl userservices;
    @Autowired
    ClaimServiceImpl ChangeStateClaim;


    @GetMapping(value = "/alluser")
    @ResponseBody
    public List<User> getAll(){
        return userservices.getAll();

    }

    @PutMapping(value = "/BannedUser/{id}")
    @ResponseBody
    public String BannedUser(@PathVariable("id") long id){
        userservices.BannedUser(id);
        return "user banned";
    }
///claim
    @GetMapping("/ChangeStateClaim/{idclaim}")
    @ResponseBody
    public String ChangeStateClaim(@PathVariable("idclaim") int claim)
{
    return ChangeStateClaim.ChangeStateClaim(claim);
}




}
