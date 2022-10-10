package com.writer.bo;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Novel extends Publication {

    private int nbOfChapters;

    public Novel(String title, String genre, String body, String synopsis, LocalDate writingDate, LocalDate updated, Author author, Language language, int nbOfWords, int nbOfChapters) {
        super(title, genre, body, synopsis, writingDate, updated, author, language, nbOfWords);
        this.nbOfChapters = nbOfChapters;
    }

    public Novel() {

    }
}
