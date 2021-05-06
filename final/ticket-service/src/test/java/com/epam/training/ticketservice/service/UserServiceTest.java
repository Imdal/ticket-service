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

    private String username = "username";
    private String password = "password";
    private String accountType = "accountType";

    @Mock
    private User user;

    @Mock
    private UserService userService;

    @Mock
    private UserDaoImpl userDao;

    @Mock
    private JpaUserRepository jpaUserRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userDao = new UserDaoImpl(jpaUserRepository);
    }



    @Test
    public void isUserSignedInShouldReturnFalse() {
        // Given
        given(userService.isUserSignedIn()).willReturn(false);

        // When
        boolean result = userService.isUserSignedIn();

        // Then
        assertThat(result, equalTo(false));
    }

    @Test
    public void isUserSignedInShouldReturnTrue() {
        // Given
        given(userService.isUserSignedIn()).willReturn(true);

        // When
        userService.signIn(user.getUsername(), user.getPassword());
        boolean result = userService.isUserSignedIn();

        // Then
        assertThat(result, equalTo(true));
    }

    @Test
    public void describeAccountShouldReturnUser() {
        // Given
        given(userService.describeAccount()).willReturn(user);

        // When
        userService.signIn(user.getUsername(), user.getPassword());
        User result = userService.describeAccount();

        // Then
        assertThat(result, equalTo(user));
    }

    @Test
    public void getUsernameShouldReturnTheUsername() {
        //Given
        User testUser = new User(username, password, accountType);

        //When
        String result = testUser.getUsername();

        // Then
        assertThat(result, equalTo(username));
    }

    @Test
    public void getPasswordShouldReturnThePassword() {
        //Given
        User testUser = new User(username, password, accountType);

        //When
        String result = testUser.getPassword();

        // Then
        assertThat(result, equalTo(password));
    }

    @Test
    public void getAccountTypeShouldReturnTheAccountType() {
        //Given
        User testUser = new User(username, password, accountType);

        //When
        String result = testUser.getAccountType();

        // Then
        assertThat(result, equalTo(accountType));
    }

}