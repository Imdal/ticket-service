package com.epam.training.ticketservice.dataaccess.projection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ScreeningProjection {
    @Id
    @GeneratedValue
    private UUID id;

    private String movieTitle;
    private String roomName;
    private LocalDateTime screeningDate;

    protected ScreeningProjection() {

    }

    public ScreeningProjection(String movieTitle, String roomName, LocalDateTime screeningDate) {
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

    public LocalDateTime getScreeningDate() {
        return screeningDate;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        ScreeningProjection screeningProjection = (ScreeningProjection) o;
        return this.getMovieTitle().equals(screeningProjection.getMovieTitle()) &&
                this.getRoomName().equals(screeningProjection.getRoomName()) &&
                this.getScreeningDate() == screeningProjection.getScreeningDate();
    }
}
