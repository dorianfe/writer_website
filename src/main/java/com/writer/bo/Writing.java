package com.writer.bo;


import javax.persistence.*;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Writing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false, nullable = false)
    protected long id;
    protected String title;
    protected String genre;
    protected String body;
    protected String synopsis;
    protected Date writingDate;
    protected Date updated;
    @ManyToOne
    protected Author author;
    protected String language;
    protected int nbOfWords;

    public Writing(long id, String title, String genre, String body, String synopsis, Date writingDate, Date updated, Author author, String language, int nbOfWords) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.body = body;
        this.synopsis = synopsis;
        this.writingDate = writingDate;
        this.updated = updated;
        this.author = author;
        this.language = language;
        this.nbOfWords = nbOfWords;
    }

    public Writing() {

    }
}
