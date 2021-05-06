package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.dataaccess.dao.MovieDao;
import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieDaoImpl implements MovieDao {
    private JpaMovieRepository jpaMovieRepository;

    @Autowired
    public MovieDaoImpl(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }

    @Override
    public void createMovie(Movie movie) {
        MovieProjection movieProjection;
        movieProjection = new MovieProjection(movie.getTitle(), movie.getGenre(), movie.getLength());
        jpaMovieRepository.save(movieProjection);
    }

    @Override
    public void deleteMovie(Movie movie) {
        MovieProjection movieProjection;
        movieProjection = new MovieProjection(movie.getTitle(), movie.getGenre(), movie.getLength());
        jpaMovieRepository.delete(movieProjection);

    }

    @Override
    public void updateMovie(Movie movie) {
        MovieProjection movieProjection;
        movieProjection = new MovieProjection(movie.getTitle(), movie.getGenre(), movie.getLength());
        jpaMovieRepository.save(movieProjection);
    }

    @Override
    public Movie getMovieByTitle(String title) {
        List<MovieProjection> movies = jpaMovieRepository.findAll();
        Movie movie = null;
        for (MovieProjection movieProjection : movies) {
            if (movieProjection.getTitle().equals(title)) {
                movie = new Movie(movieProjection.getTitle(), movieProjection.getGenre(), movieProjection.getLength());
            }
        }
        return movie;
    }

    public List<Movie> listMovies() {
        List<MovieProjection> movieProjectionList;
        List<Movie> movieList = new ArrayList<>();
        movieProjectionList = jpaMovieRepository.findAll();
        for (MovieProjection movieProjection : movieProjectionList) {
            movieList.add(new Movie(movieProjection.getTitle(), movieProjection.getGenre(),
                    movieProjection.getLength()));
        }
        return movieList;
    }
}