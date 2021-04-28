package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.domain.Movie;

import java.util.List;

public interface MovieRepository {
//    List<Movie> getAllMovie();
    void saveMovie(Movie movie);

}
