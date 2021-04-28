package com.epam.training.ticketservice.domain;

public class Movie {
    private String title;
    private String genre;
    private int length;

    public Movie(String title, String genre, int length) {
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return title + "(" + genre + ", " + length + " minutes)";
    }
}
