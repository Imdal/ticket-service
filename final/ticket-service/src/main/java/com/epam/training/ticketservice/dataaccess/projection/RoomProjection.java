package com.epam.training.ticketservice.dataaccess.projection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomProjection {

    @Id
    private String name;
    private int rowNumber;
    private int colNumber;

    protected RoomProjection() {

    }

    public RoomProjection(String name, int rowNumber, int colNumber) {
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
