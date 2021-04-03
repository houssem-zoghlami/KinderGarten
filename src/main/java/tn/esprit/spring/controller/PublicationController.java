package tn.esprit.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.service.IPublicationService;
import tn.esprit.spring.service.IUploadFileService;

@RestController
@AllArgsConstructor

@RequestMapping("/api/auth/Publication")

public class PublicationController {
    @Autowired
    IPublicationService publicationService;
    @Autowired
    IUploadFileService uploadFileService;


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


    }
