package com.writer.bo;

import javax.persistence.Entity;

@Entity
public class Visitor extends User{
    public Visitor(String firstName, String lastName, String username, String email, String role) {
        super(firstName, lastName, username, email, role);
    }

    public Visitor() {

    }
}
