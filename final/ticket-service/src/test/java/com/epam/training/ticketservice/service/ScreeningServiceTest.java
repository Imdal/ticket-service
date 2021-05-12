package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ScreeningServiceTest {

    private final String title = "title";
    private final String genre = "genre";
    private final int length = 10;
    private final Movie movie = new Movie(title, genre, length);
    private final MovieProjection movieProjection = new MovieProjection(title, genre, length);
    private final String name = "egyes";
    private final int rowNum = 10;
    private final int colNum = 10;
    private final Room room = new Room(name, rowNum, colNum);
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final LocalDateTime localDateTime1 = LocalDateTime.parse("2020-12-20 15:30", format);
    private final LocalDateTime localDateTime2 = LocalDateTime.parse("2020-12-20 15:32", format);
    private final LocalDateTime localDateTime3 = LocalDateTime.parse("2020-12-20 15:42", format);
    private final LocalDateTime localDateTime4 = LocalDateTime.parse("2020-12-20 15:52", format);
    private final Screening screening1 = new Screening(title, name, localDateTime1);
    private final Screening equalScreening = new Screening(title, name, localDateTime1);
    private final Screening screening2 = new Screening(title, name, localDateTime2);
    private final Screening screening3 = new Screening(title, name, localDateTime3);
    private final Screening screening4 = new Screening(title, name, localDateTime4);
    private ScreeningProjection screeningProjection = new ScreeningProjection(title, name, localDateTime1);

    @Mock
    private ScreeningService screeningServiceMock;
    private ScreeningService screeningService;

    @Mock
    private UserService userServiceMock;

    @Mock
    private ScreeningDaoImpl screeningDaoMock;
    private ScreeningDaoImpl screeningDao;

    @Mock
    private MovieDaoImpl movieDaoMock;
    private MovieDaoImpl movieDao;

    @Mock
    private JpaMovieRepository jpaMovieRepository;

    @Mock
    private RoomDaoImpl roomDaoMock;

    @Mock
    private JpaScreeningRepository jpaScreeningRepository;

    @Mock
    private Screening screeningMock;

    @Mock
    private List<Screening> screenings;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        movieDao = new MovieDaoImpl(jpaMovieRepository);
        screeningDao = new ScreeningDaoImpl(jpaScreeningRepository);
        screeningService = new ScreeningService(screeningDaoMock,movieDao);
        userServiceMock.signIn("admin", "admin");
        movieDaoMock.createMovie(movie);
        roomDaoMock.createRoom(room);
        screeningDaoMock.createScreening(screening1);
    }

    @Test
    public void overridedEqualShouldReturnTrue() {
        boolean result = screening1.equals(equalScreening);
        assertThat(result, equalTo(true));
    }

    @Test
    public void overridedEqualShouldReturnFalse() {
        boolean result = screening1.equals(screening2);
        assertThat(result, equalTo(false));
    }

    @Test
    public void testCreateScreening() {
        //when
        screeningService.createScreening(title, name, localDateTime1);

        //Then
        verify(screeningDaoMock, times(2)).createScreening(screening1);
    }

    @Test
    public void testToStringScreeningShouldReturnTheScreeningAsString() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        String result = screeningService.toStringScreening(screening1);
        assertThat(result, equalTo("title (genre, 10 minutes), screened in room egyes, at 2020-12-20 15:30"));
    }

    @Test
    public void testCreateScreeningShouldReturnEmptyStringIfTheScreeningCanBeCreated() {
        List<Screening> screeningList = new ArrayList<>();
        given(screeningService.listScreening()).willReturn(screeningList);

        String result = screeningService.createScreening(title, name, localDateTime1);
        assertThat(result, equalTo(""));
    }

    @Test
    public void testCreateScreeningShouldReturnErrorStringIfTheScreeningCollapseWithBreak() {
        List<Screening> screeningList = new ArrayList<>();
        screeningList.add(screening1);
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        given(screeningService.listScreening()).willReturn(screeningList);

        String result = screeningService.createScreening(title, name, localDateTime3);
        assertThat(result, equalTo("This would start in the break period after another screening in this room"));
    }

    @Test
    public void testCreateScreeningShouldReturnErrorStringIfTheScreeningCollapseWithScreening() {
        List<Screening> screeningList = new ArrayList<>();
        screeningList.add(screening1);
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        given(screeningService.listScreening()).willReturn(screeningList);

        String result = screeningService.createScreening(title, name, localDateTime2);
        assertThat(result, equalTo("There is an overlapping screening"));
    }

    @Test
    public void checkScreeningDateCollapseWithoutBreakShouldReturnFalse() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        boolean result = screeningService.checkScreeningDateCollapseWithoutBreak(screening1, screening2);

        assertThat(result, equalTo(false));
    }

    @Test
    public void checkScreeningDateCollapseWithoutBreakShouldReturnTrue() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        boolean result = screeningService.checkScreeningDateCollapseWithoutBreak(screening1, screening3);

        assertThat(result, equalTo(true));
    }

    @Test
    public void checkScreeningDateCollapseWithBreakShouldReturnFalse() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        boolean result = screeningService.checkScreeningDateCollapseWithBreak(screening1, screening3);

        assertThat(result, equalTo(false));
    }

    @Test
    public void checkScreeningDateCollapseWithBreakShouldReturnTrue() {
        List<MovieProjection> movieList = new ArrayList<>();
        movieList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieList);
        boolean result = screeningService.checkScreeningDateCollapseWithBreak(screening1, screening4);

        assertThat(result, equalTo(true));
    }


    @Test
    public void listScreeningsTestShouldReturnListOfScreenings() {
        // Given
        given(screeningDaoMock.listScreening()).willReturn(screenings);

        // When
        List<Screening> result = screeningService.listScreening();

        // Then
        assertThat(result, equalTo(screenings));
    }

    @Test
    public void stringOfScreeningsTestShouldReturnStringIfThereIsNoScreenings() {
        List<ScreeningProjection> screeningProjectionList = new ArrayList<>();
        given(jpaScreeningRepository.findAll()).willReturn(screeningProjectionList);
        String result = screeningService.stringOfScreenings();

        assertThat(result, equalTo("There are no screenings"));
    }

    @Test
    public void stringOfScreeningsTestShouldReturnOneLineOfStringIfThereIsOnlyOneScreening() {
        List<Screening> screeningList = new ArrayList<>();
        screeningList.add(screening1);
        List<MovieProjection> movieProjectionList = new ArrayList<>();
        movieProjectionList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieProjectionList);
        given(screeningDaoMock.listScreening()).willReturn(screeningList);
        String result = screeningService.stringOfScreenings();

        assertThat(result, equalTo("title (genre, 10 minutes), screened in room egyes, at 2020-12-20 15:30"));
    }

    @Test
    public void stringOfScreeningsTestShouldReturnMoreLineOfStringIfThereIsMoreThanOneScreening() {
        List<Screening> screeningList = new ArrayList<>();
        screeningList.add(screening1);
        screeningList.add(screening4);
        List<MovieProjection> movieProjectionList = new ArrayList<>();
        movieProjectionList.add(movieProjection);
        given(jpaMovieRepository.findAll()).willReturn(movieProjectionList);
        given(screeningDaoMock.listScreening()).willReturn(screeningList);
        String result = screeningService.stringOfScreenings();

        assertThat(result, equalTo("title (genre, 10 minutes), screened in room egyes, at 2020-12-20 15:30\ntitle (genre, 10 minutes), screened in room egyes, at 2020-12-20 15:52"));
    }


}