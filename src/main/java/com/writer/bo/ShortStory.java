package com.writer.bo;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;
@Entity
public class ShortStory extends Publication {

    private int maxNbOfWords;

    public ShortStory(String title, String genre, String body, String synopsis, LocalDate writingDate, LocalDate updated, Author author, Language language, int nbOfWords, int maxNbOfWords) {
        super(title, genre, body, synopsis, writingDate, updated, author, language, nbOfWords);
        this.maxNbOfWords = maxNbOfWords;
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
