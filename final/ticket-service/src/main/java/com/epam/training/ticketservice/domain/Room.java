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

}
