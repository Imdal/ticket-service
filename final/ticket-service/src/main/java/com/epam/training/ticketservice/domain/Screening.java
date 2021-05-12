package com.epam.training.ticketservice.domain;

import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;

import java.time.LocalDateTime;

public class Screening {
    private String movieTitle;
    private String roomName;
    private LocalDateTime screeningDate;

    public Screening(String movieTitle, String roomName, LocalDateTime screeningDate) {
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
        Screening screening = (Screening) o;
        return this.getMovieTitle().equals(screening.getMovieTitle()) &&
                this.getRoomName().equals(screening.getRoomName()) &&
                this.getScreeningDate() == screening.getScreeningDate();
    }
}
