package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MovieServiceTest {

    private final String title = "title";
    private final String genre = "genre";
    private final int length = 123;

    @Mock
    private MovieService movieServiceMock;
    private MovieService movieService;

    @Mock
    private UserService userService;

    @Mock
    private MovieDaoImpl movieDaoMock;
    private MovieDaoImpl movieDao;

    @Mock
    private JpaMovieRepository jpaMovieRepositoryMock;

    @Mock
    private Movie movieMock;
    private final Movie movie = new Movie(title, genre, length);

    @Mock
    private List<Movie> moviesMock;

    @BeforeEach
    public void setup() {
//        userService.signIn("admin", "admin");
        MockitoAnnotations.openMocks(this);
        movieDao = new MovieDaoImpl(jpaMovieRepositoryMock);
        movieService =  new MovieService(movieDao);
    }

//    @Test
//    public void test() {
//        userService.signIn("admin", "admin");
//        movieService.createMovie(title, genre, length);
//        movieService.updateMovie(title, genre, length);
//        movieService.deleteMovie(title);
//    }

//    @Test
//    public void testCreateMovie() {
//        movieService.createMovie(title, genre, length);
//
//        //Then
//        verify(movieDao, times(1)).createMovie(movie);
//    }
//
//    @Test
//    public void getMovieByTitleShouldReturnMovieWithTheGivenTitle() {
//        // Given
//        movieDao.createMovie(movie);
//        given(movieService.getMovieByTitle(movie.getTitle())).willReturn(movie);
//
//        // When
//        Movie result = movieService.getMovieByTitle(movie.getTitle());
//
//        // Then
//        assertThat(result.getTitle(), equalTo(movie.getTitle()));
//    }

    @Test
    public void listMoviesTestShouldReturnListOfMovies() {
        // Given
        movieDaoMock.createMovie(movieMock);
        given(movieServiceMock.listMovies()).willReturn(moviesMock);

        // When
        List<Movie> result = movieServiceMock.listMovies();

        // Then
        assertThat(result, equalTo(moviesMock));
    }

    @Test
    public void getTitleShouldReturnTheTitle() {
        //When
        String result = movie.getTitle();

        // Then
        assertThat(result, equalTo(title));
    }

    @Test
    public void getGenreShouldReturnTheGenre() {
        //When
        String result = movie.getGenre();

        // Then
        assertThat(result, equalTo(genre));
    }

    @Test
    public void getLengthShouldReturnTheLength() {
        //When
        int result = movie.getLength();

        // Then
        assertThat(result, equalTo(length));
    }
}