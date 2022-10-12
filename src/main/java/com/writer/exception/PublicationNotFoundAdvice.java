package com.writer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class PublicationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PublicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String publicationNotFoundHandler(PublicationNotFoundException e) {
        return e.getMessage();
    }
}
