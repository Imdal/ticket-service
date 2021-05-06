package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Screening;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.ScreeningService;
import com.epam.training.ticketservice.service.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ShellComponent
public class ScreeningCommandHandler {
    private ScreeningService screeningService;
    private UserService userService;
    private MovieService movieService;


    public ScreeningCommandHandler(ScreeningService screeningService,
                                   UserService userService, MovieService movieService) {
        this.screeningService = screeningService;
        this.userService = userService;
        this.movieService = movieService;
    }

    @ShellMethod(value = "Create screening", key = "create screening")
    public String createScreening(String movieTitle, String roomName, String screeningDate) {
        String result = "";
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime date = LocalDateTime.parse(screeningDate, format);
            result = screeningService.createScreening(movieTitle, roomName, date);
        }
        return result;
    }

    @ShellMethod(value = "Delete screening", key = "delete screening")
    public void deleteScreening(String movieTitle, String roomName, String screeningDate) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime date = LocalDateTime.parse(screeningDate, format);
            screeningService.deleteScreening(movieTitle, roomName, date);
        }
    }

    @ShellMethod(value = "List screenings", key = "list screenings")
    public String listScreenings() {
        return screeningService.stringOfScreenings();
    }

}
