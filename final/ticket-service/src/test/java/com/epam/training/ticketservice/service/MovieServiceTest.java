package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;

class MovieServiceTest {

    @Mock
    private MovieService movieService;

    @Mock
    private MovieDaoImpl movieDao;

    @Mock
    private JpaMovieRepository jpaMovieRepository;

    @Mock
    private Movie movie;

    @Mock
    private List<Movie> movies;

    private String title;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        movieDao = new MovieDaoImpl(jpaMovieRepository);
        movieDao.createMovie(movie);
        title=movie.getTitle();
    }

    @Test
    public void getMovieByTitleShouldReturnMovieWithTheGivenTitle() {
        // Given
        given(movieService.getMovieByTitle(title)).willReturn(movie);

        // When
        Movie result = movieService.getMovieByTitle(title);

        // Then
        assertThat(result, equalTo(movie));
    }

    @Test
    public void listMoviesTestShouldReturnListOfMovies() {
        // Given
        given(movieService.listMovies()).willReturn(movies);

        // When
        List<Movie> result = movieService.listMovies();

        // Then
        assertThat(result, equalTo(movies));
    }
}