package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.dataaccess.MovieDao;
import com.epam.training.ticketservice.dataaccess.MovieProjection;
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
        this.movieDao=movieDao;
    }

    @Override
    public void saveMovie(Movie movie) {

        movieDao.save(mapMovie(movie));
    }

    private MovieProjection mapMovie(Movie movie) {
        return new MovieProjection(movie.getTitle(), movie.getGenre(), movie.getLength());
    }



    public List<Movie> getAllMovie() {
        List<MovieProjection> movieProjections = movieDao.findAll();
        return mapMovieProjections(movieProjections);
    }

    private List<Movie> mapMovieProjections(List<MovieProjection> movieProjections) {
        return movieProjections.stream()
                .map(this::mapMovieProjection)
                .collect(Collectors.toList());
    }

    private Movie mapMovieProjection(MovieProjection movieProjection) {
        return new MovieImpl(movieProjection.getTitle(), movieProjection.getGenre(), movieProjection.getLength());
    }
}
