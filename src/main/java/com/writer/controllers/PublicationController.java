package com.writer.controllers;

import com.writer.bll.PublicationService;
import com.writer.bo.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/publications/{id}")
    EntityModel<Publication> one(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Publication publication = publicationService.getOnePublication(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        System.out.println("cnx sur one()");
        return EntityModel.of(publication, linkTo(methodOn(PublicationController.class).one(id)).withSelfRel(),
                linkTo(methodOn(PublicationService.class).listAllPublications()).withRel("publications"));
    }

    @PostMapping(value = "/nouvellePublication", produces = "application/json")
    public ResponseEntity<Publication> addPublication(@RequestBody Publication p, UriComponentsBuilder ucBuilder) {
        System.out.println("tentative de POST");

        publicationService.addPublication(p);
        List<Publication> publications = publicationService.listAllPublications();
        int nb = publications.size();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(nb).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
