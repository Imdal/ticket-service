package com.epam.training.ticketservice.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    //private User currentUser;

    AuthService() {

    }

    public boolean logIn(String username, String password) {
        System.out.println("logIn");
        return false;
    }

    public boolean logOut() {
        return true;
//        if(currentUser==null)
//            return false;
//        else {
//            currentUser = null;
//            return true;
//        }
    }

    public String describeAccount() {
//        return currentUser.getAccountType();
        return "valami";
    }
}
