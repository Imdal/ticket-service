package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.domain.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyMovieRepository implements MovieRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(DummyMovieRepository.class);

    @Override
    public void saveMovie(Movie movie) {
        LOGGER.info("Saving movie {}", movie);
    }
}

