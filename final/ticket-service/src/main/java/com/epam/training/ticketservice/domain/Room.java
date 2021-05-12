package com.epam.training.ticketservice.domain;

public class Room {
    private String name;
    private int rowNumber;
    private int colNumber;

    public Room(String name, int rowNumber, int colNumber) {
        this.name = name;
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    public String getName() {
        return name;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        Room room = (Room) o;
        return this.getName().equals(room.getName()) &&
                this.getRowNumber() == room.getRowNumber() &&
                this.getColNumber() == room.getColNumber();
    }
}
