package com.epam.training.ticketservice.domain;

public class Screening {
    private String movieTitle;
    private String roomName;
    private java.sql.Timestamp screeningDate;

    public Screening(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
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
