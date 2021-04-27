package com.epam.training.ticketservice;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Command {

    private AuthService authService;

    public Command(AuthService authService) {
        this.authService = authService;
    }

//    public void getCommand() {
//        System.out.print("Ticket service>");
//        Scanner input = new Scanner(System.in);
//        readCommand(input.nextLine());
//
//    }

    @ShellMethod(value = "Exit program", key = "exit")
    public void exit() {
        System.exit(0);
    }

    @ShellMethod(value = "Log in", key="log in")
    public void login(String username, String password) {
        authService.logIn(username, password);
    }

//    private boolean readCommand(String command) {
////        command.lastIndexOf("")
//        if(command.toLowerCase().contains("sign out")) {
//            auth.logOut();
//            System.out.println("Logged out");
//        }
//        if(command.toLowerCase().contains("sign in privileged")) {
//            String[] parts = command.substring(command.lastIndexOf("privileged")+"privileged".length()+1).split(" ");
//            auth.logIn(parts[0],parts[1]);
//        }
//        else
//        if(command.toLowerCase().equals("exit")) {
//            System.exit(0);
//        }
//        else return false;
//        return true;
//
//    }

}
