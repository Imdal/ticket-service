package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import com.epam.training.ticketservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDao{
    void createUser(User user);
    User getUserByName(String name);
}
