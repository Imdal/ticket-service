package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.UserDatabaseInitializer;
import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.UserDaoImpl;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaUserRepository;
import com.epam.training.ticketservice.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MovieServiceTest {

    private final String title = "title";
    private final String genre = "genre";
    private final int length = 123;
    private final int length2 = 1234;

    @Mock
    private MovieService movieServiceMock;
    private MovieService movieService;

    @Mock
    private JpaUserRepository jpaUserRepositoryMock;
    @Mock
    private UserDaoImpl userDaoMock;
    private UserDaoImpl userDao;
    private UserService userService;

    @Mock
    UserDatabaseInitializer userDatabaseInitializer;

    @Mock
    private MovieDaoImpl movieDaoMock;
    private MovieDaoImpl movieDao;

    @Mock
    private JpaMovieRepository jpaMovieRepositoryMock;

    @Mock
    private Movie movieMock;
    private final Movie movie = new Movie(title, genre, length);;
    private final Movie equalMovie = new Movie(title, genre, length);
    private final Movie notEqualMovie = new Movie(title, genre, length2);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userDao = new UserDaoImpl(jpaUserRepositoryMock);
        userService = new UserService(userDaoMock);
        movieDao = new MovieDaoImpl(jpaMovieRepositoryMock);
        movieService =  new MovieService(movieDaoMock);
    }

    @Test
    public void overridedEqualShouldReturnTrue() {
        boolean result = movie.equals(equalMovie);
        assertThat(result, equalTo(true));
    }

    @Test
    public void overridedEqualShouldReturnFalse() {
        boolean result = movie.equals(notEqualMovie);
        assertThat(result, equalTo(false));
    }

    @Test
    public void testCreateMovieShouldCallMovieDaoCreateMovie() {
        movieService.createMovie(title, genre, length);
        verify(movieDaoMock, times(1)).createMovie(movie);
    }

    @Test
    public void testUpdateMovieShouldCallMovieDaoUpdateMovie() {
        movieService.updateMovie(title, genre, length);
        verify(movieDaoMock, times(1)).updateMovie(movie);
    }

    @Test
    public void testDeleteMovieShouldCallMovieDaoDeleteMovie() {
        given(movieDaoMock.getMovieByTitle(title)).willReturn(movie);
        movieService.deleteMovie(title);
        verify(movieDaoMock, times(1)).deleteMovie(movie);
    }

    @Test
    public void testCreateMovie() {
        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(movie);
        given(movieService.listMovies()).willReturn(expectedResult);

        movieService.createMovie(title, genre, length);
        List<Movie> result = movieService.listMovies();

        //Then
        assertThat(result, equalTo(expectedResult));
    }


    @Test
    public void testDeleteMovie() {
        movieService.createMovie(title, genre, length);
        List<Movie> expectedResult = new ArrayList<>();
        given(movieService.listMovies()).willReturn(expectedResult);

        movieService.deleteMovie(title);
        List<Movie> result = movieService.listMovies();
        //Then
        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void getMovieByTitleShouldReturnNullIfTheMovieNotExists() {
        // Given
        given(movieService.getMovieByTitle(movie.getTitle())).willReturn(null);

        // When
        Movie result = movieService.getMovieByTitle(movie.getTitle());

        // Then
        assertThat(result, equalTo(null));
    }

    @Test
    public void getMovieByTitleShouldReturnMovieWithTheGivenTitle() {
        // Given
        movieDao.createMovie(movie);
        given(movieService.getMovieByTitle(movie.getTitle())).willReturn(movie);

        // When
        Movie result = movieService.getMovieByTitle(movie.getTitle());

        // Then
        assertThat(result, equalTo(movie));
    }

    @Test
    public void listMoviesTestShouldReturnEmptyListIfNoMoviesCreated() {
        List<Movie> movieList = new ArrayList<>();
        given(movieService.listMovies()).willReturn(movieList);

        // When
        List<Movie> result = movieService.listMovies();

        // Then
        assertThat(result, equalTo(movieList));
    }

    @Test
    public void listMoviesTestShouldReturnListOfMovies() {
        // Given
        movieDaoMock.createMovie(movieMock);
        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(movieMock);
        given(movieService.listMovies()).willReturn(expectedResult);

        // When
        List<Movie> result = movieService.listMovies();


        // Then
        assertThat(result, equalTo(expectedResult));
    }


}