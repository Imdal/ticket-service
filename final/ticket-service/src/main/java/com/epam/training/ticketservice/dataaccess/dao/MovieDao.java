package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieDao extends JpaRepository<MovieProjection, UUID> {
}
