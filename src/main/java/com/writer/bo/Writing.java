package com.writer.bo;

import java.util.Date;

public abstract class Writing {
    private String title;
    private String genre;
    private String body;
    private String synopsis;
    private Date writingDate;
    private Date updated;
    private Author author;
    private String language;
    private int size;

    public Writing(String title, String genre, String body, String synopsis, Date writingDate, Date updated, Author author, Language language) {
        this.title = title;
        this.genre = genre;
        this.body = body;
        this.synopsis = synopsis;
        this.writingDate = writingDate;
        this.updated = updated;
        this.author = author;
        this.language = language.getLanguage();
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

    public Date getWritingDate() {
        return writingDate;
    }

    public void setWritingDate(Date writingDate) {
        this.writingDate = writingDate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
