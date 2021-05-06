package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    private ScreeningDaoImpl screeningDao;
    private MovieDaoImpl movieDao;

    ScreeningService(ScreeningDaoImpl screeningDao) {
        this.screeningDao = screeningDao;
    }

    public void createScreening(String movieTitle, String roomName,
                                java.sql.Date screeningDate, java.sql.Time screeningTime) {
        Screening screening = new Screening(movieTitle, roomName, screeningDate, screeningTime);
        List<Screening> screeningList = listScreening();
        for (Screening screeningObject : screeningList)
//        List<Movie> movieList = movieDao.listMovies();
//        for(Screening)
//        movieList


        screeningDao.createScreening(new Screening(movieTitle, roomName, screeningDate, screeningTime));
    }

    public void deleteScreening(String movieTitle, String roomName,
                                java.sql.Date screeningDate, java.sql.Time screeningTime) {
        screeningDao.deleteScreening(new Screening(movieTitle, roomName, screeningDate, screeningTime));
    }

    public List<Screening> listScreening() {
        return screeningDao.listScreening();
    }

    public boolean checkScreeningDate(Screening screeningToCheck, Screening screeningFromList) {
        int lengthOfScreeningToCheck = movieDao.getMovieByTitle(screeningToCheck.getMovieTitle()).getLength();
        int lengthOfScreeningFromList = movieDao.getMovieByTitle(screeningFromList.getMovieTitle()).getLength();
//        if(lengthOfScreeningToCheck*600000000)
        return true;

    }
}
