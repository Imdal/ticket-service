package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import org.springframework.stereotype.Service;

@Service
public class ScreeningService {

    ScreeningService() {

    }

    public boolean createScreening(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
        System.out.println("createScreening");
        return false;
    }

//    public boolean updateScreening(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
//        System.out.println("updateScreening");
//        return false;
//    }

    public boolean deleteScreening(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
        System.out.println("deleteScreening");
        return false;
    }

    //    public Collection<Movie> listMovies() {
    public Screening listScreening() {
        System.out.println("listScreening");
        java.sql.Timestamp ts = new java.sql.Timestamp(1000000000);
        return new Screening("","",ts);
    }
}
