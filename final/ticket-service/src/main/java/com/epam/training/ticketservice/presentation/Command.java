package com.epam.training.ticketservice.presentation;

import com.epam.training.ticketservice.service.AuthService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Command {

    private AuthService authService;

    public Command(AuthService authService) {
        this.authService = authService;
    }

//    @ShellMethod(value = "Exit program", key = "exit")
//    public void exit() {
//        System.exit(0);
//    }

    @ShellMethod(value = "Log in", key = "log in")
    public void login(String username, String password) {
        authService.logIn(username, password);
    }


}
