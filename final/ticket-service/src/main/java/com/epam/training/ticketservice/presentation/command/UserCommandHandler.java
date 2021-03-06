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
    public String signIn(String username, String password) {
        String result = "";
        if (!userService.signIn(username, password)) {
            result = "Login failed due to incorrect credentials";
        }
        return result;
    }

    @ShellMethod(value = "Sign in privileged", key = "sign in privileged")
    public String signInPrivileged(String username, String password) {
        String result = "";
        if (!userService.signIn(username, password)) {
            result = "Login failed due to incorrect credentials";
        }
        return result;
    }

    @ShellMethod(value = "Sign out", key = "sign out")
    public void signOut() {
        userService.signOut();
    }

    @ShellMethod(value = "Describe account", key = "describe account")
    public String describeAccount() {
        User user = userService.describeAccount();
        String result = "";

        if (!userService.isUserSignedIn()) {
            result = "You are not signed in";
        } else if (user.getAccountType().equals("admin")) {
            result = "Signed in with privileged account '" + user.getUsername() + "'";
        } else {
            result = "Signed in with account '" + user.getUsername() + "'";
        }
        return result;
    }

}
