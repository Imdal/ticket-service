package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.RoomDao;
import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomDaoImpl roomDao;

    RoomService(RoomDaoImpl roomDao) {
        this.roomDao = roomDao;
    }

    public void createRoom(String name, int rowNumber, int colNumber) {
        roomDao.createRoom(new Room(name, rowNumber, colNumber));
    }

    public void updateRoom(String name, int rowNumber, int colNumber) {
        roomDao.updateRoom(new Room(name, rowNumber, colNumber));
    }

    public void deleteRoom(String name, int rowNumber, int colNumber) {
        roomDao.deleteRoom(new Room(name, rowNumber, colNumber));
    }

    public List<Room> listRooms() {
        return roomDao.listRooms();
    }

    public Room getRoomByName(String name) {
        return roomDao.getRoomByName(name);
    }
}
