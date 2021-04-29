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
    private java.sql.Date screeningDate;
    private java.sql.Time screeningTime;

    protected ScreeningProjection() {

    }

    public ScreeningProjection(String movieTitle, String roomName, java.sql.Date screeningDate,
                               java.sql.Time screeningTime) {
        this.movieTitle = movieTitle;
        this.roomName = roomName;
        this.screeningDate = screeningDate;
        this.screeningTime = screeningTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getRoomName() {
        return roomName;
    }

    public java.sql.Date getScreeningDate() {
        return screeningDate;
    }

    public java.sql.Time getScreeningTime() {
        return screeningTime;
    }
}
