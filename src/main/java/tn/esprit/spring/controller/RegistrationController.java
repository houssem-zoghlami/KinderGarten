package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.RegistrationRequest;
import tn.esprit.spring.service.RegistrationService;

@RestController
@RequestMapping(path = "/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
        //return "registered";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
