package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieDao{
    List<Movie> listMovies();
    void createMovie(Movie movie);
    void deleteMovie(Movie movie);
    void updateMovie(Movie movie);
}
