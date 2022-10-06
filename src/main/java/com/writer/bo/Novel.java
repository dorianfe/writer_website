package com.writer.bo;

import java.util.Date;

public class Novel extends Writing{

    public Novel(String title, String genre, String body, String synopsis, Date writingDate, Date updated, Author author, Language language) {
        super(title, genre, body, synopsis, writingDate, updated, author, language);
    }
}
