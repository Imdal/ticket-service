package com.epam.training.ticketservice.dataaccess.projection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ScreeningProjection {
    @Id
    @GeneratedValue
    private UUID id;

    private String movieTitle;
    private String roomName;
    private java.sql.Timestamp screeningDate;

    protected ScreeningProjection() {

    }

    private ScreeningProjection(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
        this.movieTitle = movieTitle;
        this.roomName = roomName;
        this.screeningDate = screeningDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getRoomName() {
        return roomName;
    }

    public java.sql.Timestamp getScreeningDate() {
        return screeningDate;
    }
}
