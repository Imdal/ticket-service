package com.epam.training.ticketservice.dataaccess;

import com.epam.training.ticketservice.dataaccess.dao.UserDao;
import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserDatabaseInitializer {
    private UserDao userDao;

    public UserDatabaseInitializer(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostConstruct
    public void initDatabase() {
        List<UserProjection> products = List.of(
                new UserProjection("admin", "admin", "admin"));
        products.forEach(userDao::save);
    }
}
