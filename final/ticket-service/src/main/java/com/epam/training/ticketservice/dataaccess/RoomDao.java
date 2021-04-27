package com.epam.training.ticketservice.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomDao extends JpaRepository<RoomProjection, UUID> {
}
