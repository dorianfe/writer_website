package com.writer.controllers;
import com.writer.exception.PublicationNotFoundException;

import com.writer.bll.PublicationService;
import com.writer.bo.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PublicationController {

    private PublicationService publicationService;
    private final PublicationModelAssembler assembler;

    public PublicationController(PublicationService publicationService, PublicationModelAssembler assembler) {
        this.publicationService = publicationService;
        this.assembler = assembler;
    }

    int nbCnx = 1;



    @GetMapping(value = "/publications", produces = "application/json")
    public CollectionModel<EntityModel<Publication>> all() {
        List<EntityModel<Publication>> publications = publicationService.listAllPublications()
                .stream().map(publication -> EntityModel.of(publication,
                        linkTo(methodOn(PublicationController.class).one(publication.getId())).withSelfRel(),
                        linkTo(methodOn(PublicationController.class).all()).withRel("publications")))
                .collect(Collectors.toList());


        System.out.println("Connexion sur publications" + nbCnx);
        nbCnx++;
        return CollectionModel.of(publications, linkTo(methodOn(PublicationController.class).all()).withSelfRel());
    }

    @GetMapping("/publications/{id}")
    EntityModel<Publication> one(@PathVariable Long id) {
        Publication publication = publicationService.getOnePublication(id)
                .orElseThrow(() -> new PublicationNotFoundException(id));
        System.out.println("cnx sur one()");
        return EntityModel.of(publication,
                linkTo(methodOn(PublicationController.class).one(id)).withSelfRel(),
                linkTo(methodOn(PublicationService.class).listAllPublications()).withRel("publications"));
    }

    @PostMapping(value = "/publications/new", produces = "application/json")
    public ResponseEntity<Publication> add(@RequestBody Publication p, UriComponentsBuilder ucBuilder) {
        System.out.println("tentative de POST");

        publicationService.addPublication(p);
        List<Publication> publications = publicationService.listAllPublications();
        int nb = publications.size();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(nb).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
