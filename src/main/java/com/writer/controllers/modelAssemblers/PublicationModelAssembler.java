package com.writer.controllers.modelAssemblers;

import com.writer.bo.Publication;
import com.writer.controllers.PublicationController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PublicationModelAssembler implements RepresentationModelAssembler<Publication, EntityModel<Publication>> {


    @Override
    public EntityModel<Publication> toModel(Publication publication) {
        return EntityModel.of(publication,
                WebMvcLinkBuilder.linkTo(methodOn(PublicationController.class).one(publication.getId())).withSelfRel(),
                linkTo(methodOn(PublicationController.class).all()).withRel("publications"));
    }
}
