package com.epam.training.ticketservice.dataaccess.dao.implementation;

import com.epam.training.ticketservice.dataaccess.dao.ScreeningDao;
import com.epam.training.ticketservice.dataaccess.projection.ScreeningProjection;
import com.epam.training.ticketservice.dataaccess.repository.JpaScreeningRepository;
import com.epam.training.ticketservice.domain.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreeningDaoImpl implements ScreeningDao {
    private JpaScreeningRepository jpaScreeningRepository;

    @Autowired
    public ScreeningDaoImpl(JpaScreeningRepository jpaScreeningRepository) {
        this.jpaScreeningRepository = jpaScreeningRepository;
    }


    @Override
    public void createScreening(Screening screening) {
        ScreeningProjection screeningProjection;

        screeningProjection = new ScreeningProjection(screening.getMovieTitle(), screening.getRoomName(), screening.getScreeningDate(), screening.getScreeningTime());
        try {
            jpaScreeningRepository.save(screeningProjection);
        }
        catch(Exception e){
        }
    }

    @Override
    public void deleteScreening(Screening screening) {
        ScreeningProjection screeningProjection;

        screeningProjection = new ScreeningProjection(screening.getMovieTitle(), screening.getRoomName(), screening.getScreeningDate(), screening.getScreeningTime());
        try {
            jpaScreeningRepository.delete(screeningProjection);
        }
        catch(Exception e){
        }
    }

    public List<Screening> listScreening() {
        List<ScreeningProjection> screeningProjectionList;
        List<Screening> screeningList = new ArrayList<>() {
        };

        screeningProjectionList = jpaScreeningRepository.findAll();

        for(ScreeningProjection screening : screeningProjectionList) {
            screeningList.add(new Screening(screening.getMovieTitle(), screening.getRoomName(), screening.getScreeningDate(), screening.getScreeningTime()));
        }

        return screeningList;
    }
}
