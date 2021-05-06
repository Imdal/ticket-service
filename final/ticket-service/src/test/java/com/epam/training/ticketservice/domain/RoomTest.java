package com.epam.training.ticketservice.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RoomTest {

    private final String name = "name";
    private final int rowNum = 10;
    private final int colNum = 12;
    private final Room room = new Room(name, rowNum, colNum);

    @Test
    public void getNameShouldReturnTheName() {
        //When
        String result = room.getName();

        // Then
        assertThat(result, equalTo(name));
    }

    @Test
    public void getRowNumberShouldReturnTheNumberOfRows() {
        //When
        int result = room.getRowNumber();

        // Then
        assertThat(result, equalTo(rowNum));
    }

    @Test
    public void getColNumberShouldReturnTheNumberOfColumns() {
        //When
        int result = room.getColNumber();

        // Then
        assertThat(result, equalTo(colNum));
    }
}
