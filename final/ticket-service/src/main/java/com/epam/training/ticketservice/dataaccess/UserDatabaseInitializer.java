package com.epam.training.ticketservice.dataaccess;

import com.epam.training.ticketservice.dataaccess.dao.UserDao;
import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaUserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserDatabaseInitializer {
    private JpaUserRepository jpaUserRepository;

    public UserDatabaseInitializer(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @PostConstruct
    public void initDatabase() {
        List<UserProjection> products = List.of(
                new UserProjection("admin", "admin", "admin"));
        products.forEach(jpaUserRepository::save);
    }
}
