package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.service.RoomService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class RoomCommandHandler {
    private RoomService roomService;

    public RoomCommandHandler(RoomService roomService) {
        this.roomService = roomService;
    }

    @ShellMethod(value = "Create room", key = "create room")
    public void createRoom(String name, int rowNumber, int colNumber) {
        roomService.createRoom(name, rowNumber, colNumber);
    }

    @ShellMethod(value = "Update room", key = "update room")
    public void updateRoom(String name, int rowNumber, int colNumber) {
        roomService.updateRoom(name, rowNumber, colNumber);
    }

    @ShellMethod(value = "Delete room", key = "delete room")
    public void deleteRoom(String name, int rowNumber, int colNumber) {
        roomService.deleteRoom(name, rowNumber, colNumber);
    }

    @ShellMethod(value = "List rooms", key = "list rooms")
    public void listRooms() {
        roomService.listRooms();
    }
}
