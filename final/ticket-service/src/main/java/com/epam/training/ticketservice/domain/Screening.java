package com.epam.training.ticketservice.domain;

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
}
