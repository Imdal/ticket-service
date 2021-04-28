package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.dataaccess.projection.RoomProjection;
import com.epam.training.ticketservice.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;

public interface RoomDao extends JpaRepository<RoomProjection, UUID> {
//    Collection<Room> listRooms();
//    void createRoom(Room room);
//    void deleteRoom(Room room);
//    void updateRoom(Room room);
}
