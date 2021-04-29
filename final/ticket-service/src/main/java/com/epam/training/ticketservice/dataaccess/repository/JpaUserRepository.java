package com.epam.training.ticketservice.dataaccess.repository;

import com.epam.training.ticketservice.dataaccess.dao.UserDao;
import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;
import com.epam.training.ticketservice.dataaccess.projection.UserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserProjection, UUID>  {
    List<UserProjection> findAll();
    UserProjection save(UserProjection userProjection);

}