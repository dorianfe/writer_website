package com.writer.controllers;

import com.writer.bo.Publication;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PublicationModelAssembler implements RepresentationModelAssembler<Publication, EntityModel<Publication>> {


    @Override
    public EntityModel<Publication> toModel(Publication publication) {
        return EntityModel.of(publication,
                linkTo(methodOn(PublicationController.class).one(publication.getId())).withSelfRel(),
                linkTo(methodOn(PublicationController.class).all()).withRel("publications"));
    }
}
