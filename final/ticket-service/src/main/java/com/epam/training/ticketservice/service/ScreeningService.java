package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningService {

    private ScreeningDaoImpl screeningDao;
    private MovieDaoImpl movieDao;

    ScreeningService(ScreeningDaoImpl screeningDao, MovieDaoImpl movieDao) {
        this.movieDao = movieDao;
        this.screeningDao = screeningDao;
    }

    public String createScreening(String movieTitle, String roomName,
                                LocalDateTime screeningDate) {
        String result = "";
        Screening screening = new Screening(movieTitle, roomName, screeningDate);
        List<Screening> screeningList =  Collections.<Screening>emptyList();
        screeningList = listScreening().stream().filter(screeningObj ->
                screeningObj.getRoomName().equals(roomName)).collect(Collectors.toList());
        if (!screeningList.isEmpty()) {
            for (Screening screeningObject : screeningList) {
                if (!checkScreeningDateCollapseWithBreak(screening, screeningObject)) {
                    result = "This would start in the break period after another screening in this room";
                }
                if (!checkScreeningDateCollapseWithoutBreak(screening, screeningObject)) {
                    result = "There is an overlapping screening";
                }
            }
        }
        if (result.equals("")) {
            screeningDao.createScreening(new Screening(movieTitle, roomName, screeningDate));
        }
        return result;
    }

    public void deleteScreening(String movieTitle, String roomName,
                                LocalDateTime screeningDate) {
        screeningDao.deleteScreening(new Screening(movieTitle, roomName, screeningDate));
    }

    public  List<Screening> listScreening() {
        return screeningDao.listScreening();
    }

    public String stringOfScreenings() {
        String result = "";
        List<Screening> screeningList = screeningDao.listScreening();
        if (screeningList.isEmpty()) {
            result = "There are no screenings";
        } else {
            for (Screening screening : screeningList) {
                result = result.concat(toStringScreening(screening));
                result = result.concat("\n");
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public boolean checkScreeningDateCollapseWithoutBreak(Screening screeningToCheck, Screening screeningFromList) {
        boolean result = false;
        int lengthOfScreeningToCheck = movieDao.getMovieByTitle(screeningToCheck.getMovieTitle()).getLength();
        int lengthOfScreeningFromList = movieDao.getMovieByTitle(screeningFromList.getMovieTitle()).getLength();
        if (screeningToCheck.getScreeningDate().plusMinutes(lengthOfScreeningToCheck)
                .compareTo(screeningFromList.getScreeningDate()) < 0
                ||
                screeningFromList.getScreeningDate().plusMinutes(lengthOfScreeningFromList)
                .compareTo(screeningToCheck.getScreeningDate()) < 0) {
            result = true;
        }
        return result;
    }

    public boolean checkScreeningDateCollapseWithBreak(Screening screeningToCheck, Screening screeningFromList) {
        boolean result = false;
        int lengthOfScreeningToCheck = movieDao.getMovieByTitle(screeningToCheck.getMovieTitle()).getLength();
        int lengthOfScreeningFromList = movieDao.getMovieByTitle(screeningFromList.getMovieTitle()).getLength();

        if (screeningToCheck.getScreeningDate().plusMinutes(lengthOfScreeningToCheck + 10)
                .compareTo(screeningFromList.getScreeningDate()) < 0
                ||
                screeningFromList.getScreeningDate().plusMinutes(lengthOfScreeningFromList + 10)
                        .compareTo(screeningToCheck.getScreeningDate()) < 0) {
            result = true;
        }
        return result;
    }


    public String toStringScreening(Screening screening) {
        Movie movie = movieDao.getMovieByTitle(screening.getMovieTitle());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = screening.getScreeningDate().format(format);
        String result = screening.getMovieTitle() + " (" + movie.getGenre() + ", " + movie.getLength()
                + " minutes), screened in room " + screening.getRoomName() + ", at "
                + formattedDate;
        return result;
    }
}
