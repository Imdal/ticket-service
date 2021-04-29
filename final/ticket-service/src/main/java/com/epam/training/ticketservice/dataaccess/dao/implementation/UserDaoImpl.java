package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.dao.UserDao;
import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;
import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
import com.epam.training.ticketservice.dataaccess.repository.JpaUserRepository;
import com.epam.training.ticketservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private JpaUserRepository jpaUserRepository;

    @Autowired
    public UserDaoImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void createUser(User user) {
        UserProjection userProjection;

        userProjection = new UserProjection(user.getUsername(), user.getPassword(), user.getAccountType());
        jpaUserRepository.save(userProjection);

    }

    @Override
    public User getUserByName(String name) {
        List<UserProjection> users = jpaUserRepository.findAll();
        User user = null;
        for (UserProjection userProjection : users) {
            if (userProjection.getUsername().equals(name)) {
                user = new User(userProjection.getUsername(), userProjection.getPassword(),
                        userProjection.getAccountType());
            }
        }
        return user;
    }
}
