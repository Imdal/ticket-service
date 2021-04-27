package com.epam.training.ticketservice.dataaccess;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomProjection {

    @Id
    private String name;
    private int row;
    private int col;

    protected RoomProjection() {}

    public RoomProjection(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public String getName() {return name;}

    public int getRow() {return row;}

    public int getCol() {return col;}
}
