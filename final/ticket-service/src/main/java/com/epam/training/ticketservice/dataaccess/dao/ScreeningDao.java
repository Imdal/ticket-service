package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.domain.Screening;

import java.util.List;

public interface ScreeningDao {
    List<Screening> listScreening();
    void createScreening(Screening screening);
    void deleteScreening(Screening screening);
}
