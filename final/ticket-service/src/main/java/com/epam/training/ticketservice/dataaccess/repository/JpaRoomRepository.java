package com.epam.training.ticketservice.dataaccess.repository;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.projection.RoomProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRoomRepository extends JpaRepository<RoomProjection, String> {
    List<RoomProjection> findAll();

    RoomProjection save(RoomProjection roomProjection);

    void delete(RoomProjection roomProjection);
}
