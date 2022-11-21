package com.writer.controllers.modelAssemblers;

import com.writer.bo.Publication;
import com.writer.bo.User;
import com.writer.controllers.PublicationController;
import com.writer.controllers.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {


    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                WebMvcLinkBuilder.linkTo(methodOn(PublicationController.class).one(user.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("publications"));
    }
}
