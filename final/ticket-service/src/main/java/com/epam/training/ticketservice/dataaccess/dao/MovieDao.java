package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface MovieDao extends JpaRepository<MovieProjection, UUID> {
//    Collection<Movie> listMovies();
//    void createMovie(Movie movie);
//    void deleteMovie(Movie movie);
//    void updateMovie(Movie movie);
}
