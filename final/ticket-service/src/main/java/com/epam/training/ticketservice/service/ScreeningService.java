package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    private ScreeningDaoImpl screeningDao;

    ScreeningService(ScreeningDaoImpl screeningDao) {
        this.screeningDao = screeningDao;
    }

    public void createScreening(String movieTitle, String roomName,
                                java.sql.Date screeningDate, java.sql.Time screeningTime) {
        screeningDao.createScreening(new Screening(movieTitle, roomName, screeningDate, screeningTime));
    }

    public void deleteScreening(String movieTitle, String roomName,
                                java.sql.Date screeningDate, java.sql.Time screeningTime) {
        screeningDao.deleteScreening(new Screening(movieTitle, roomName, screeningDate, screeningTime));
    }

    public List<Screening> listScreening() {
        return screeningDao.listScreening();
    }
}
