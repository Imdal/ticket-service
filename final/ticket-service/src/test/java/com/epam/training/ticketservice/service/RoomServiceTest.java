package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.MovieDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.RoomDaoImpl;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaRoomRepository;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RoomServiceTest {

    @Mock
    private RoomService roomService;

    @Mock
    private RoomDaoImpl roomDao;

    @Mock
    private JpaRoomRepository jpaRoomRepository;

    @Mock
    private Room room;

    @Mock
    private List<Room> rooms;

    private String name;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        roomDao = new RoomDaoImpl(jpaRoomRepository);
        roomDao.createRoom(room);
        name=room.getName();
        name=room.getName();
    }

    @Test
    public void getRoomByTitleShouldReturnRoomWithTheGivenName() {
        // Given
        given(roomService.getRoomByName(name)).willReturn(room);

        // When
        Room result = roomService.getRoomByName(name);

        // Then
        assertThat(result, equalTo(room));
    }

    @Test
    public void listRoomsTestShouldReturnListOfRooms() {
        // Given
        given(roomService.listRooms()).willReturn(rooms);

        // When
        List<Room> result = roomService.listRooms();

        // Then
        assertThat(result, equalTo(rooms));
    }

}