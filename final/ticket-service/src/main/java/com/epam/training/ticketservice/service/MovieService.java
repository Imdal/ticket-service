package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieDaoImpl movieDao;

    @Autowired
    public MovieService(MovieDaoImpl movieDao) {
        this.movieDao = movieDao;
    }

    public void createMovie(String title, String genre, int length) {
        movieDao.createMovie(new Movie(title, genre, length));
    }

    public void updateMovie(String title, String genre, int length) {
        movieDao.updateMovie(new Movie(title, genre, length));
    }

    public void deleteMovie(String title, String genre, int length) {
        movieDao.deleteMovie(new Movie(title, genre, length));
    }

    public List<Movie> listMovies() {
        return movieDao.listMovies();
    }

    public Movie getMovieByTitle(String title) {
        return movieDao.getMovieByTitle(title);
    }
}
