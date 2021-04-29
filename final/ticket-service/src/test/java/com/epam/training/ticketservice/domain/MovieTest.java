package com.epam.training.ticketservice.domain;

import com.epam.training.ticketservice.dataaccess.dao.implementation.UserDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class MovieTest {

    @Mock
    private Movie movie;

    private String title;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        title = movie.getTitle();
    }

    @Test
    public void getTitleShouldReturnString() {
        // Given
        given(movie.getTitle()).willReturn(title);

        // When
        String result = movie.getTitle();

        // Then
        assertThat(result, equalTo(title));
    }

}