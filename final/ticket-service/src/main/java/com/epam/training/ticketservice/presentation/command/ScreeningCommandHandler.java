package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.ScreeningService;
import com.epam.training.ticketservice.service.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@ShellComponent
public class ScreeningCommandHandler {
    private ScreeningService screeningService;
    private UserService userService;
    private MovieService movieService;


    public ScreeningCommandHandler(ScreeningService screeningService, UserService userService) {
        this.screeningService = screeningService;
        this.userService = userService;
    }

    @ShellMethod(value = "Create screening", key = "create screening")
    public void createScreening(String movieTitle, String roomName, String screeningDate, String screeningTime) {
        if (userService.idUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            Date date = Date.valueOf(screeningDate);
            Time time = Time.valueOf(screeningTime + ":00");
            screeningService.createScreening(movieTitle, roomName, date, time);
        }
    }

    @ShellMethod(value = "Delete screening", key = "delete screening")
    public void deleteScreening(String movieTitle, String roomName, String screeningDate, String screeningTime) {
        if (userService.idUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            Date date = Date.valueOf(screeningDate);
            Time time = Time.valueOf(screeningTime + ":00");
            screeningService.deleteScreening(movieTitle, roomName, date, time);
        }
    }

    @ShellMethod(value = "List screenings", key = "list screenings")
    public void listScreenings() {
        List<Screening> screeningList = screeningService.listScreening();
        if (screeningList.isEmpty()) {
            System.out.println("There are no screenings");
        } else {
            for (Screening screening : screeningList) {
                System.out.println(toStringScreening(screening));
            }
        }
    }

    private String toStringScreening(Screening screening) {
        Movie movie = movieService.getMovieByTitle(screening.getMovieTitle());
        return screening.getMovieTitle() + "(" + movie.getGenre() + ", " + movie.getLength()
                + " minutes), screened in room " + screening.getRoomName() + ", at "
                + screening.getScreeningDate().toString() + " "
                + screening.getScreeningTime().toString().substring(0,5);

    }
}
