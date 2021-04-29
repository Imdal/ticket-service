package com.epam.training.ticketservice.dataaccess.repository;

import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaScreeningRepository extends JpaRepository<ScreeningProjection, UUID> {
    List<ScreeningProjection> findAll();

    ScreeningProjection save(ScreeningProjection screeningProjection);

    void delete(ScreeningProjection screeningProjection);

}
