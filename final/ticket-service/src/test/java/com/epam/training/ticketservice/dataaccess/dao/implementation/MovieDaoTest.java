package com.epam.training.ticketservice.dataaccess.dao.implementation;

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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class MovieDaoTest {

    private MovieDaoImpl underTest;

    @Mock
    private JpaMovieRepository jpaMovieRepository;

    @Mock
    private List<Movie> movies;

    @Mock
    private MovieProjection movie;

    @Mock
    private MovieProjection movieProjection;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new MovieDaoImpl(jpaMovieRepository);
        jpaMovieRepository.save(movie);
    }



//    @Test
//    public void listMoviesTest() {
//        // Given
//        given(underTest.listMovies()).willReturn(movies);
//
//        // When
//        List<Movie> result = underTest.listMovies();
//
//        // Then
//        assertThat(result, equalTo(movies));
//    }
}