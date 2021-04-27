package com.epam.training.ticketservice.domain;

public class MovieImpl implements Movie {
    private final String title;
    private final String genre;
    private final int length;

    public MovieImpl(String title, String genre, int length) {
        this.title=title;
        this.genre=genre;
        this.length=length;
    }

    @Override
    public String getTitle() {return title;}

    @Override
    public String getGenre() {return genre;}

    @Override
    public int getLength() {return length;}

    @Override
    public String toString() {
        return title + "(" + genre +", " + length + " minutes)";
    }

}
