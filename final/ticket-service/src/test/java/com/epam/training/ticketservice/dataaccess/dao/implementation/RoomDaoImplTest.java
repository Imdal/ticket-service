package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.projection.RoomProjection;
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

class RoomDaoImplTest {

    @Mock
    private JpaRoomRepository jpaRoomRepository;
    private RoomDaoImpl roomDao;

    private final String name = "name";
    private int rowNum = 10;
    private int colNum = 12;
    private RoomProjection roomProjection = new RoomProjection(name, rowNum, colNum);
    private Room room = new Room(name, rowNum, colNum);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        roomDao = new RoomDaoImpl(jpaRoomRepository);
    }

    @Test
    public void getRoomByNameShouldReturnNullIfTheRoomNotExists() {
        List<RoomProjection> roomProjectionList = new ArrayList<>();
        given(jpaRoomRepository.findAll()).willReturn(roomProjectionList);

        Room result = roomDao.getRoomByName(name);

        assertThat(result, equalTo(null));
    }

    @Test
    public void getRoomByTitleShouldReturnTheRoomIfTheMovieExists() {
        List<RoomProjection> roomProjectionList = new ArrayList<>();
        roomProjectionList.add(roomProjection);
        given(jpaRoomRepository.findAll()).willReturn(roomProjectionList);

        Room result = roomDao.getRoomByName(name);

        assertThat(result.getName(), equalTo(name));
        assertThat(result.getRowNumber(), equalTo(rowNum));
        assertThat(result.getColNumber(), equalTo(colNum));
    }

    @Test
    public void listRoomsTestShouldReturnEmptyListIfNoRoomsCreated() {
        List<RoomProjection> roomProjectionList = new ArrayList<>();
        given(jpaRoomRepository.findAll()).willReturn(roomProjectionList);

        List<Room> expectedResult = new ArrayList<>();
        List<Room> result = roomDao.listRooms();

        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void listRoomsTestShouldReturnAllOfTheRooms() {
        List<RoomProjection> roomProjectionList = new ArrayList<>();
        roomProjectionList.add(roomProjection);
        given(jpaRoomRepository.findAll()).willReturn(roomProjectionList);

        List<Room> expectedResult = new ArrayList<>();
        expectedResult.add(room);
        List<Room> result = roomDao.listRooms();

        assertThat(result.size(), equalTo(expectedResult.size()));
    }

}