package com.writer.bo;

public enum Language {
    ENGLISH(1, "english"), FRENCH(2, "french"), ITALIAN(3, "italian");

    private final int id;
    private final String language;

    Language(int id, String language) {
        this.id = id;
        this.language = language;
    }

    public int getId() {
        return id;
    }


    public String getLanguage() {
        return language;
    }

}
