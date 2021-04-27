package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.dataaccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository {
    private UserDao userDao;

    @Autowired
    public JpaUserRepository(UserDao userDao) {
        this.userDao=userDao;
    }
}
