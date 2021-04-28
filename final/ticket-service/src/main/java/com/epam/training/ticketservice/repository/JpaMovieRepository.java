package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.dataaccess.dao.MovieDao;
import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.MovieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaMovieRepository {

    private MovieDao movieDao;

    @Autowired
    public JpaMovieRepository(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

}
