package com.epam.training.ticketservice.dataaccess.dao;

import com.epam.training.ticketservice.dataaccess.projection.RoomProjection;
import com.epam.training.ticketservice.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;

public interface ScreeningDao extends JpaRepository<RoomProjection, UUID> {
//    Collection<Screening> listScreening();
//    void createScreening(Screening screening);
//    void deleteScreening(Screening screening);
}
