package com.writer.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
@Entity
public class ShortStory extends Writing{


    public ShortStory(long id, String title, String genre, String body, String synopsis, Date writingDate, Date updated, Author author, String language, int nbOfWords) {
        super(id, title, genre, body, synopsis, writingDate, updated, author, language, nbOfWords);
    }

    public ShortStory() {

    }
}
