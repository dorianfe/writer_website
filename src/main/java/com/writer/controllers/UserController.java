package com.writer.controllers;

import com.writer.bll.UserService;
import com.writer.bo.Publication;
import com.writer.bo.User;
import com.writer.controllers.modelAssemblers.UserModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserService userService;
    private final UserModelAssembler assembler;

    public UserController(UserService userService, UserModelAssembler assembler) {
        this.userService = userService;
        this.assembler = assembler;
    }
    int nbCnx;

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
                user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @GetMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }


    @GetMapping(value = "/users", produces = "application/json")
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = userService.listAll()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());

        System.out.println("Connexion sur users" + nbCnx);
        nbCnx++;
        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }
}
