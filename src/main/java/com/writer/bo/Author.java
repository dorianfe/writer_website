package com.writer.bo;

import javax.persistence.Entity;

@Entity
public class Author extends User {

    public Author(String firstName, String lastName, String username, String email, String role) {
        super(firstName, lastName, username, email, role);
    }

    public Author() {

    }
}
