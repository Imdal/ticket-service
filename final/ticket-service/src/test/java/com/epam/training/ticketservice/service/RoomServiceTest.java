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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RoomServiceTest {

    private String name = "egyes";
    private int rowNum = 10;
    private int rowNum2 = 12;
    private int colNum = 10;
    private final Room room = new Room(name, rowNum, colNum);
    private final Room equalRoom = new Room(name, rowNum, colNum);
    private final Room notEqualRoom = new Room(name, rowNum2, colNum);

    @Mock
    private RoomService roomServiceMock;
    private RoomService roomService;

    @Mock
    private RoomDaoImpl roomDaoMock;
    private RoomDaoImpl roomDao;

    @Mock
    private JpaRoomRepository jpaRoomRepository;

    @Mock
    private Room roomMock;

    @Mock
    private List<Room> rooms;



    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        roomDao = new RoomDaoImpl(jpaRoomRepository);
        roomService = new RoomService(roomDaoMock);
        roomDao.createRoom(room);
    }

    @Test
    public void overridedEqualShouldReturnTrue() {
        boolean result = room.equals(equalRoom);
        assertThat(result, equalTo(true));
    }

    @Test
    public void overridedEqualShouldReturnFalse() {
        boolean result = room.equals(notEqualRoom);
        assertThat(result, equalTo(false));
    }

    @Test
    public void testCreateRoomShouldCallRoomDaoCreateRoom() {
        roomService.createRoom(name, rowNum, colNum);
        verify(roomDaoMock, times(1)).createRoom(room);
    }

    @Test
    public void testCreateRoom() {
        List<Room> expectedResult = new ArrayList<>();
        expectedResult.add(room);
        given(roomService.listRooms()).willReturn(expectedResult);

        roomService.createRoom(name, rowNum, colNum);
        List<Room> result = roomService.listRooms();

        //Then
        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void testDeleteRoom() {
        roomDaoMock.createRoom(roomMock);
        List<Room> expectedResult = new ArrayList<>();
        given(roomService.listRooms()).willReturn(expectedResult);

        roomService.deleteRoom(roomMock.getName());
        List<Room> result = roomService.listRooms();
        //Then
        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void getRoomByTitleShouldReturnRoomWithTheGivenName() {
        // Given
        roomDao.createRoom(room);
        given(roomService.getRoomByName(room.getName())).willReturn(room);

        // When
        Room result = roomService.getRoomByName(room.getName());

        // Then
        assertThat(result, equalTo(room));
    }

    @Test
    public void getRoomByTitleShouldReturnNullIfTheRoomNotExists() {
        // Given
        given(roomService.getRoomByName(room.getName())).willReturn(null);

        // When
        Room result = roomService.getRoomByName(room.getName());

        // Then
        assertThat(result, equalTo(null));
    }

    @Test
    public void listRoomsTestShouldReturnListOfRooms() {
        // Given
        roomDaoMock.createRoom(roomMock);
        List<Room> expectedResult = new ArrayList<>();
        expectedResult.add(roomMock);
        given(roomService.listRooms()).willReturn(expectedResult);

        // When
        List<Room> result = roomService.listRooms();

        // Then
        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void listRoomsTestShouldReturnNullIfNoRoomsCreated() {
        // Given
        List<Room> expectedResult = new ArrayList<>();
        given(roomService.listRooms()).willReturn(expectedResult);

        // When
        List<Room> result = roomService.listRooms();

        // Then
        assertThat(result, equalTo(expectedResult));
    }

}