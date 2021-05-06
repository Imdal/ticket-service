package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.service.RoomService;
import com.epam.training.ticketservice.service.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class RoomCommandHandler {
    private RoomService roomService;
    private UserService userService;

    public RoomCommandHandler(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @ShellMethod(value = "Create room", key = "create room")
    public void createRoom(String name, int rowNumber, int colNumber) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            roomService.createRoom(name, rowNumber, colNumber);
        }
    }

    @ShellMethod(value = "Update room", key = "update room")
    public void updateRoom(String name, int rowNumber, int colNumber) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            roomService.updateRoom(name, rowNumber, colNumber);
        }
    }

    @ShellMethod(value = "Delete room", key = "delete room")
    public void deleteRoom(String name) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            roomService.deleteRoom(name);
        }
    }

    @ShellMethod(value = "List rooms", key = "list rooms")
    public String listRooms() {
        List<Room> roomList = roomService.listRooms();
        String result = "";
        if (roomList.isEmpty()) {
            result = "There are no rooms at the moment";
        } else {
            for (Room room: roomList) {
                result += toStringRoom(room) +"\n";
            }
            result = result.substring(0,result.length()-1);
        }
        return result;
    }

    public String toStringRoom(Room room) {
        return "Room " + room.getName() + " with " + room.getRowNumber() * room.getColNumber() + " seats, "
                + room.getRowNumber() + " rows and " + room.getColNumber() + " columns";
    }
}
