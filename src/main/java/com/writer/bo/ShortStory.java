package com.writer.bo;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class ShortStory extends Publication {

    private int maxNbOfWords;

    public ShortStory(long id, String title, String genre, String body, String synopsis, Date writingDate, Date updated, Author author, String language, int nbOfWords) {
        super(id, title, genre, body, synopsis, writingDate, updated, author, language, nbOfWords);
    }

    public ShortStory() {

    }

    public int getMaxNbOfWords() {
        return maxNbOfWords;
    }

    public void setMaxNbOfWords(int maxNbOfWords) {
        this.maxNbOfWords = maxNbOfWords;
    }
}
