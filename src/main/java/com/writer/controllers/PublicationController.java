package com.writer.controllers;
import com.writer.controllers.modelAssemblers.PublicationModelAssembler;
import com.writer.exception.PublicationNotFoundException;

import com.writer.bll.PublicationService;
import com.writer.bo.Publication;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
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

    private final PublicationService publicationService;
    private final PublicationModelAssembler assembler;

    public PublicationController(PublicationService publicationService, PublicationModelAssembler assembler) {
        this.publicationService = publicationService;
        this.assembler = assembler;
    }

    int nbCnx = 1;
    @GetMapping(value = "/publications", produces = "application/json")
    public CollectionModel<EntityModel<Publication>> all() {
        List<EntityModel<Publication>> publications = publicationService.listAll()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());

        System.out.println("Connexion sur publications" + nbCnx);
        nbCnx++;
        return CollectionModel.of(publications, linkTo(methodOn(PublicationController.class).all()).withSelfRel());
    }

    @GetMapping("/publications/{id}")
    public EntityModel<Publication> one(@PathVariable Long id) {
        Publication publication = publicationService.getOne(id)
                .orElseThrow(() -> new PublicationNotFoundException(id));
        System.out.println("cnx sur one()");
        return assembler.toModel(publication);
    }

    @PostMapping(value = "/publications")
    public ResponseEntity<?> add(@RequestBody Publication p) {

        EntityModel<Publication> entityModel = assembler.toModel(publicationService.addPublication(p));
        System.out.println("tentative de POST");
       return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
               .body(entityModel);
    }
}
