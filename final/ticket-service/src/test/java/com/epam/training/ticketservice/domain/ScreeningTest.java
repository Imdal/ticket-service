package com.epam.training.ticketservice.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ScreeningTest {

    private final String title = "title";
    private final String name = "name";
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final LocalDateTime screeningDate = LocalDateTime.parse("2020-12-20 15:30", format);
    private final Screening screening = new Screening(title, name, screeningDate);

    @Test
    public void getMovieTitleShouldReturnTheTitle() {
        //When
        String result = screening.getMovieTitle();

        // Then
        assertThat(result, equalTo(title));
    }

    @Test
    public void getRoomNameShouldReturnTheName() {
        //When
        String result = screening.getRoomName();

        // Then
        assertThat(result, equalTo(name));
    }

    @Test
    public void getScreeningDateShouldReturnTheDateOfScreening() {
        //When
        LocalDateTime result = screening.getScreeningDate();

        // Then
        assertThat(result, equalTo(screeningDate));
    }
}
