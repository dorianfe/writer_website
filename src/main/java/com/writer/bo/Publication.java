package com.writer.bo;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false, nullable = false)
    protected long id;
    protected String title;
    protected String genre;
    protected String body;
    protected String synopsis;
    protected LocalDate writingDate;
    protected LocalDate updated;
    @ManyToOne
    protected Author author;
    protected String language;
    protected int nbOfWords;

    public Publication(String title, String genre, String body, String synopsis, LocalDate writingDate, LocalDate updated, Author author, Language language, int nbOfWords) {
        this.title = title;
        this.genre = genre;
        this.body = body;
        this.synopsis = synopsis;
        this.writingDate = writingDate;
        this.updated = updated;
        this.author = author;
        this.language = language.getLanguage();
        this.nbOfWords = nbOfWords;
    }

    public Publication() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public LocalDate getWritingDate() {
        return writingDate;
    }

    public void setWritingDate(LocalDate writingDate) {
        this.writingDate = writingDate;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNbOfWords() {
        return nbOfWords;
    }

    public void setNbOfWords(int nbOfWords) {
        this.nbOfWords = nbOfWords;
    }
}
