package com.epam.training.ticketservice.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {

    private String username = "username";
    private String password = "password";
    private String accountType = "accountType";

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
