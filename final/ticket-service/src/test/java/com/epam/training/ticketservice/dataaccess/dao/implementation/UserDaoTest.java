package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.projection.MovieProjection;
import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaMovieRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaUserRepository;
import com.epam.training.ticketservice.domain.Movie;
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

class UserDaoTest {

    @Mock
    private JpaUserRepository jpaUserRepository;
    private UserDaoImpl userDao;

    private String username = "admin";
    private String password = "admin";
    private String accountType = "admin";

    private User user = new User(username, password, accountType);
    private UserProjection userProjection = new UserProjection(username, password, accountType);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userDao = new UserDaoImpl(jpaUserRepository);
    }

    @Test
    public void getUserByUsernameShouldReturnNullIfTheUserNotExists() {
        List<UserProjection> userProjectionList = new ArrayList<>();
        given(jpaUserRepository.findAll()).willReturn(userProjectionList);

        User result = userDao.getUserByName(username);

        assertThat(result, equalTo(null));
    }

    @Test
    public void getUserByTitleShouldReturnTheUserIfTheUserExists() {
        List<UserProjection> userProjectionList = new ArrayList<>();
        userProjectionList.add(userProjection);
        given(jpaUserRepository.findAll()).willReturn(userProjectionList);

        User result = userDao.getUserByName(username);

        assertThat(result.getUsername(), equalTo(username));
        assertThat(result.getPassword(), equalTo(password));
        assertThat(result.getAccountType(), equalTo(accountType));
    }

}