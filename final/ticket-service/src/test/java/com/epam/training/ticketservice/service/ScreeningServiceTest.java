package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Screening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class ScreeningServiceTest {

    @Mock
    private ScreeningService screeningService;

    @Mock
    private ScreeningDaoImpl screeningDao;

    @Mock
    private JpaScreeningRepository jpaScreeningRepository;

    @Mock
    private Screening screening;

    @Mock
    private List<Screening> screenings;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        screeningDao = new ScreeningDaoImpl(jpaScreeningRepository);
        screeningDao.createScreening(screening);
    }


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