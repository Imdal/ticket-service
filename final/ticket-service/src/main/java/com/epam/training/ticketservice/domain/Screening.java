package com.epam.training.ticketservice.domain;

public class Screening {
    private String movieTitle;
    private String roomName;
    private java.sql.Date screeningDate;
    private java.sql.Time screeningTime;

    public Screening(String movieTitle, String roomName, java.sql.Date screeningDate, java.sql.Time screeningTime) {
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
