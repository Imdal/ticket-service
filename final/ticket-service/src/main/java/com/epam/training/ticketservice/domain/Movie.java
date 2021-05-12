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
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }

    @Override
    public boolean equals(Object o) {
        Movie movie = (Movie) o;
        return this.getTitle().equals(movie.getTitle()) &&
                this.getGenre().equals(movie.getGenre()) &&
                this.getLength() == movie.getLength();
    }
}
