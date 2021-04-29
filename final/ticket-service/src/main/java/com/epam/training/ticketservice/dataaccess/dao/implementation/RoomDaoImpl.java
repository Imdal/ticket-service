package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.dao.RoomDao;
import com.epam.training.ticketservice.dataaccess.projection.RoomProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaRoomRepository;
import com.epam.training.ticketservice.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomDaoImpl implements RoomDao {
    private JpaRoomRepository jpaRoomRepository;

    @Autowired
    public RoomDaoImpl(JpaRoomRepository jpaRoomRepository) {
        this.jpaRoomRepository = jpaRoomRepository;
    }


    @Override
    public void createRoom(Room room) {
        RoomProjection roomProjection;

        roomProjection = new RoomProjection(room.getName(), room.getRowNumber(), room.getColNumber());
        jpaRoomRepository.save(roomProjection);
    }

    @Override
    public void deleteRoom(Room room) {
        RoomProjection roomProjection;

        roomProjection = new RoomProjection(room.getName(), room.getRowNumber(), room.getColNumber());
        jpaRoomRepository.delete(roomProjection);
    }

    @Override
    public void updateRoom(Room room) {
        RoomProjection roomProjection;

        roomProjection = new RoomProjection(room.getName(), room.getRowNumber(), room.getColNumber());
        jpaRoomRepository.save(roomProjection);
    }

    @Override
    public Room getRoomByName(String name) {
        List<RoomProjection> rooms = jpaRoomRepository.findAll();
        Room room = null;
        for (RoomProjection roomProjection : rooms) {
            if (roomProjection.getName().equals(name)) {
                room = new Room(roomProjection.getName(), roomProjection.getRowNumber(),roomProjection.getColNumber());
            }
        }
        return room;
    }

    public List<Room> listRooms() {
        List<RoomProjection> roomProjectionList;
        List<Room> roomList = new ArrayList<>() {
        };

        roomProjectionList = jpaRoomRepository.findAll();

        for (RoomProjection roomProjection : roomProjectionList) {
            roomList.add(new Room(roomProjection.getName(), roomProjection.getRowNumber(),
                    roomProjection.getColNumber()));
        }

        return roomList;
    }
}
