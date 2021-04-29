package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.service.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class UserCommandHandler {

    private UserService userService;

    public UserCommandHandler(UserService userService) {
        this.userService = userService;
    }

    @ShellMethod(value = "Sign up", key = "sign up")
    public void signUp(String username, String password) {
        userService.signUp(username, password);
    }

    @ShellMethod(value = "Sign in", key = "sign in")
    public void signIn(String username, String password) {
        userService.signIn(username, password);
    }

    @ShellMethod(value = "Sign in privileged", key = "sign in privileged")
    public void signInPrivileged(String username, String password) {
        userService.signIn(username, password);
    }

    @ShellMethod(value = "Sign out", key = "sign out")
    public void signOut() {
        userService.signOut();
    }

    @ShellMethod(value = "Describe account", key = "describe account")
    public void describeAccount() {
        User user = userService.describeAccount();

        if (!userService.isUserSignedIn()) {
            System.out.println("You are not signed in");
        } else if (user.getAccountType().equals("admin")) {
            System.out.println("Signed in with privileged account '" + user.getUsername() + "'");
        } else {
            System.out.println("Signed in with account '" + user.getUsername() + "'");
        }

    }

}
