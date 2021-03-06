package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.dataaccess.dao.implementation.ScreeningDaoImpl;
import com.epam.training.ticketservice.dataaccess.dao.implementation.UserDaoImpl;
import com.epam.training.ticketservice.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static User currentUser;

    private UserDaoImpl userDao;

    UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void signUp(String username, String password) {
        userDao.createUser(new User(username, password, "user"));
    }

    public boolean signIn(String username, String password) {
        User user = userDao.getUserByName(username);
        if (user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        } else {
            return false;
        }
    }

    public void signOut() {
        currentUser = null;
    }

    public User describeAccount() {
        return currentUser;
    }

    public boolean isUserSignedIn() {
        if (currentUser == null) {
            return false;
        } else {
            return true;
        }
    }
}
