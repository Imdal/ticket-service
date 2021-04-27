package com.epam.training.ticketservice.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieDao extends JpaRepository<MovieProjection, UUID> {
}
