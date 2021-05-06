package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.UserDaoImpl;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaUserRepository;
import com.epam.training.ticketservice.domain.Screening;
import com.epam.training.ticketservice.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class UserServiceTest {

    private String username = "admin";
    private String password = "admin";
    private String accountType = "admin";

    @Mock
    private User userMock;
    private User user = new User(username, password, accountType);


    @Mock
    private UserService userServiceMock;
    private UserService userService;

    @Mock
    private UserDaoImpl userDaoMock;
    private UserDaoImpl userDao;

    @Mock
    private JpaUserRepository jpaUserRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userDao = new UserDaoImpl(jpaUserRepository);
        userService = new UserService(userDaoMock);
    }



    @Test
    public void isUserSignedInShouldReturnFalse() {
        // When
        boolean result = userService.isUserSignedIn();

        // Then
        assertThat(result, equalTo(false));
    }

//    @Test
//    public void isUserSignedInShouldReturnTrue() {
//        // Given
//        userServiceMock.signIn(username, password);
//
//        // When
//        boolean result = userService.isUserSignedIn();
//
//        // Then
//        assertThat(result, equalTo(true));
//    }
//
//    @Test
//    public void describeAccountShouldReturnUser() {
//        // Given
//        userServiceMock.signIn(username, password);
//        given(userService.describeAccount()).willReturn(user);
//
//        // When
//        userService.signIn(username, password);
//        User result = userService.describeAccount();
//
//        // Then
//        assertThat(result, equalTo(user));
//    }



}