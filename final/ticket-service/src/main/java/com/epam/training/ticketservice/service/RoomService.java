package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    RoomService() {

    }

    public boolean createRoom(String name, int rowNumber, int colNumber) {
        System.out.println("createRoom");
        return false;
    }

    public boolean updateRoom(String name, int rowNumber, int colNumber) {
        System.out.println("updateRoom");
        return false;
    }

    public boolean deleteRoom(String name, int rowNumber, int colNumber) {
        System.out.println("deleteRoom");
        return false;
    }

    //    public Collection<Movie> listMovies() {
    public Room listRooms() {
        System.out.println("listRooms");
        return new Room("",0,0);
    }
}
