package com.epam.training.ticketservice.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MovieTest {

    private final String title = "title";
    private final String genre = "genre";
    private final int length = 123;
    private final Movie movie = new Movie(title, genre, length);

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
