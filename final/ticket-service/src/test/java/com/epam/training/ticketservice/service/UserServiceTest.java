package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.UserDaoImpl;
import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaUserRepository;
import com.epam.training.ticketservice.domain.Screening;
import com.epam.training.ticketservice.domain.User;
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

class UserServiceTest {

    private String username = "admin";
    private String password = "admin";
    private String accountType = "admin";

    @Mock
    private User userMock;
    private User user = new User(username, password, accountType);
    private UserProjection userProjection = new UserProjection(username, password, accountType);


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
        userService = new UserService(userDao);
    }

    @Test
    public void signInShouldReturnFalseIfWrongPasswordGiven() {
        List<UserProjection> userProjectionList = new ArrayList<>();
        userProjectionList.add(userProjection);
        given(jpaUserRepository.findAll()).willReturn(userProjectionList);
        boolean result = userService.signIn(username,"1234");
        assertThat(result, equalTo(false));
    }

    @Test
    public void signInShouldReturnTrueIfCorrectPasswordGiven() {
        List<UserProjection> userProjectionList = new ArrayList<>();
        userProjectionList.add(userProjection);
        given(jpaUserRepository.findAll()).willReturn(userProjectionList);
        boolean result = userService.signIn(username,password);
        assertThat(result, equalTo(true));
    }



    @Test
    public void isUserSignedInShouldReturnFalse() {
        // When
        userService.signOut();
        boolean result = userService.isUserSignedIn();

        // Then
        assertThat(result, equalTo(false));
    }

    @Test
    public void isUserSignedInShouldReturnTrue() {
        // Given
        List<UserProjection> userProjectionList = new ArrayList<>();
        userProjectionList.add(userProjection);
        given(jpaUserRepository.findAll()).willReturn(userProjectionList);
        userService.signIn(username,password);

        // When
        boolean result = userService.isUserSignedIn();

        // Then
        assertThat(result, equalTo(true));
    }

    @Test
    public void describeAccountShouldReturnUser() {
        // Given
        List<UserProjection> userProjectionList = new ArrayList<>();
        userProjectionList.add(userProjection);
        given(jpaUserRepository.findAll()).willReturn(userProjectionList);
        userService.signIn(username,password);

        // When
        User result = userService.describeAccount();

        // Then
        assertThat(result.getUsername(), equalTo(user.getUsername()));
        assertThat(result.getPassword(), equalTo(user.getPassword()));
        assertThat(result.getAccountType(), equalTo(user.getAccountType()));
    }

    @Test
    public void describeAccountShouldReturnNullIfUserNotSignedIn() {
        userService.signOut();

        // When
        User result = userService.describeAccount();

        // Then
        assertThat(result, equalTo(null));
    }



}