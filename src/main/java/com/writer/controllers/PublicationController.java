package com.writer.controllers;

import com.writer.bll.PublicationService;
import com.writer.bo.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PublicationController {

    @Autowired
    private PublicationService publicationService;
    int nbCnx = 1;

    @GetMapping(value = "/publications", produces = "application/json")
    public List<Publication> publications() {
        List<Publication> publications = publicationService.listAllPublications();
        String cnx = "Connexion sur publications";

        System.out.println("Connexion sur publications" + nbCnx);
        nbCnx++;
        return publications;
    }

    @PostMapping(value = "/nouvellePublication", produces = "application/json")
    public ResponseEntity<Publication> addPublication(@RequestBody Publication p, UriComponentsBuilder ucBuilder) {

        publicationService.addPublication(p);
        List<Publication> publications = publicationService.listAllPublications();
        int nb = publications.size();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(nb).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
