package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.projection.RoomProjection;
import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaRoomRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.timeout;

class ScreeningDaoTest {

    @Mock
    private JpaScreeningRepository jpaScreeningRepository;
    private ScreeningDaoImpl screeningDao;

    private String movieTitle = "title";
    private final String roomName = "name";
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final LocalDateTime localDateTime = LocalDateTime.parse("2020-12-20 15:30", format);
    private ScreeningProjection screeningProjection = new ScreeningProjection(movieTitle, roomName, localDateTime);
    private Screening screening = new Screening(movieTitle, roomName, localDateTime);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        screeningDao = new ScreeningDaoImpl(jpaScreeningRepository);
    }

    @Test
    public void listScreeningsTestShouldReturnEmptyListIfNoScreeningsCreated() {
        List<ScreeningProjection> screeningProjectionList = new ArrayList<>();
        given(jpaScreeningRepository.findAll()).willReturn(screeningProjectionList);

        List<Screening> expectedResult = new ArrayList<>();
        List<Screening> result = screeningDao.listScreening();

        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void listScreeningsTestShouldReturnAllOfTheScreenings() {
        List<ScreeningProjection> screeningProjectionList = new ArrayList<>();
        screeningProjectionList.add(screeningProjection);
        given(jpaScreeningRepository.findAll()).willReturn(screeningProjectionList);

        List<Screening> expectedResult = new ArrayList<>();
        expectedResult.add(screening);
        List<Screening> result = screeningDao.listScreening();

        assertThat(result.size(), equalTo(expectedResult.size()));
    }

}