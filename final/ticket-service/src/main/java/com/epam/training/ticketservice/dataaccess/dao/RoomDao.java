package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.domain.Room;

import java.util.Collection;
import java.util.List;

public interface RoomDao {
    List<Room> listRooms();

    void createRoom(Room room);

    void deleteRoom(Room room);

    void updateRoom(Room room);

    Room getRoomByName(String name);
}
