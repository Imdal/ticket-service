package com.epam.training.ticketservice.dataaccess.projection;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieProjection {

    @Id
    private String title;
    private String genre;
    private int length;

    protected MovieProjection() { }

    public MovieProjection(String title, String genre, int length) {
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

}
