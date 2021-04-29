package com.epam.training.ticketservice.dataaccess.repository;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JpaMovieRepository extends JpaRepository<MovieProjection, String> {
    List<MovieProjection> findAll();

    MovieProjection save(MovieProjection movieProjection);

    void delete(MovieProjection movieProjection);
}
