package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
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
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class ScreeningServiceTest {

    private final String title = "title";
    private final String genre = "genre";
    private final int length = 10;
    private final Movie movie = new Movie(title, genre, length);
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
    private final Screening screening2 = new Screening(title, name, localDateTime2);
    private final Screening screening3 = new Screening(title, name, localDateTime3);
    private final Screening screening4 = new Screening(title, name, localDateTime4);

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

    @Mock
    private RoomDaoImpl roomDaoMock;

    @Mock
    private JpaScreeningRepository jpaScreeningRepository;

    @Mock
    private Screening screeningMock;

    @Mock
    private List<Screening> screenings;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        screeningDao = new ScreeningDaoImpl(jpaScreeningRepository);
        userServiceMock.signIn("admin", "admin");
        movieDaoMock.createMovie(movie);
        roomDaoMock.createRoom(room);
        screeningDaoMock.createScreening(screening1);
    }

//    @Test
//    public void checkScreeningDateCollapseWithoutBreakShouldReturnFalse() {
//        boolean result = screeningService.checkScreeningDateCollapseWithoutBreak(screening1, screening3);
//
//        assertThat(result, equalTo(false));
//    }
//
//    @Test
//    public void checkScreeningDateCollapseWithoutBreakShouldReturnTrue() {
//        boolean result = screeningService.checkScreeningDateCollapseWithoutBreak(screening1, screening4);
//
//        assertThat(result, equalTo(true));
//    }
//
//    @Test
//    public void checkScreeningDateCollapseWithBreakShouldReturnFalse() {
//        boolean result = screeningService.checkScreeningDateCollapseWithBreak(screening1, screening2);
//
//        assertThat(result, equalTo(false));
//    }
//
//    @Test
//    public void checkScreeningDateCollapseWithBreakShouldReturnTrue() {
//        boolean result = screeningService.checkScreeningDateCollapseWithBreak(screening1, screening3);
//
//        assertThat(result, equalTo(true));
//    }
//
//
//    @Test
//    public void listScreeningsTestShouldReturnListOfScreenings() {
//        // Given
//        given(screeningService.listScreening()).willReturn(screenings);
//
//        // When
//        List<Screening> result = screeningService.listScreening();
//
//        // Then
//        assertThat(result, equalTo(screenings));
//    }

}