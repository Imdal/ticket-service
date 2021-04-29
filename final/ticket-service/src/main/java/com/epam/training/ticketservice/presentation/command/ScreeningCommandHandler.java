package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.domain.Screening;
import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.ScreeningService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class ScreeningCommandHandler {
    private ScreeningService screeningService;

    public ScreeningCommandHandler(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @ShellMethod(value = "Create screening", key = "create screening")
    public void createScreening(String movieTitle, String roomName, java.sql.Date screeningDate, java.sql.Time screeningTime) {
        screeningService.createScreening(movieTitle, roomName, screeningDate, screeningTime);
    }

//    @ShellMethod(value = "Update screening", key = "update screening")
//    public void updateRoom(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
//        screeningService.updateScreening(movieTitle, roomName, screeningDate);
//    }

    @ShellMethod(value = "Delete screening", key = "delete screening")
    public void deleteScreening(String movieTitle, String roomName, java.sql.Date screeningDate, java.sql.Time screeningTime) {
        screeningService.deleteScreening(movieTitle, roomName, screeningDate, screeningTime);
    }

    @ShellMethod(value = "List screenings", key = "list screenings")
    public void listScreenings() {
        List<Screening> screeningList = screeningService.listScreening();
        if (screeningList.isEmpty())
            System.out.println("There are no screenings");
        else
            System.out.println(screeningList.toString());
    }
}
