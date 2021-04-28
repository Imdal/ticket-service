package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.ScreeningService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ScreeningCommandHandler {
    private ScreeningService screeningService;

    public ScreeningCommandHandler(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @ShellMethod(value = "Create screening", key = "create screening")
    public void createRoom(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
        screeningService.createScreening(movieTitle, roomName, screeningDate);
    }

//    @ShellMethod(value = "Update screening", key = "update screening")
//    public void updateRoom(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
//        screeningService.updateScreening(movieTitle, roomName, screeningDate);
//    }

    @ShellMethod(value = "Delete screening", key = "delete screening")
    public void deleteRoom(String movieTitle, String roomName, java.sql.Timestamp screeningDate) {
        screeningService.deleteScreening(movieTitle, roomName, screeningDate);
    }

    @ShellMethod(value = "List screenings", key = "list screenings")
    public void listRooms() {
        screeningService.listScreening();
    }
}
