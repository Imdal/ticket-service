package com.epam.training.ticketservice.dataaccess;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ScreeningProjection {
    @Id
    @GeneratedValue
    private UUID id;

    private String movieTitle;
    private String roomName;
//    private date;
}
