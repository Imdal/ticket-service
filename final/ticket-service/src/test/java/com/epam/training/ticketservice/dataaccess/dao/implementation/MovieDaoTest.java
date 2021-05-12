package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class MovieDaoTest {

    @Mock
    private JpaMovieRepository jpaMovieRepository;
    private MovieDaoImpl movieDao;

    private final String title = "title";
    private final String genre = "genre";
    private final int length = 123;
    private MovieProjection movieProjection = new MovieProjection(title, genre, length);
    private Movie movie = new Movie(title, genre, length);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        movieDao = new MovieDaoImpl(jpaMovieRepository);
    }

    @Test
    public void getMovieByTitleShouldReturnNullIfTheMovieNotExists() {
        List<MovieProjection> movieList = new ArrayList<>();
        given(jpaMovieRepository.findAll()).willReturn(movieList);

        Movie result = movieDao.getMovieByTitle(movie.getTitle());

        assertThat(result, equalTo(null));
    }

    @Test
    public void getMovieByTitleShouldReturnTheMovieIfTheMovieExists() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);

        Movie result = movieDao.getMovieByTitle(movie.getTitle());

        assertThat(result.getTitle(), equalTo(movie.getTitle()));
        assertThat(result.getGenre(), equalTo(movie.getGenre()));
        assertThat(result.getLength(), equalTo(movie.getLength()));
    }

    @Test
    public void listMoviesTestShouldReturnEmptyListIfNoMoviesCreated() {
        List<MovieProjection> movieList = new ArrayList<>();
        given(jpaMovieRepository.findAll()).willReturn(movieList);

        List<Movie> expectedResult = new ArrayList<>();
        List<Movie> result = movieDao.listMovies();

        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void listMoviesTestShouldReturnAllOfTheMovies() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);

        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(movie);
        List<Movie> result = movieDao.listMovies();

        assertThat(result.size(), equalTo(expectedResult.size()));
    }
}