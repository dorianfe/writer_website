package com.writer.exception;

public class PublicationNotFoundException extends RuntimeException{

    public PublicationNotFoundException(Long id) {
        super("Publication with id : " + id + " could be not found.");
    }
}
