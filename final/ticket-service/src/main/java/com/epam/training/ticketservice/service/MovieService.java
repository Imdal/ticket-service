package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieService {

    MovieService() {

    }

    public boolean createMovie(String title, String genre, int length) {
        System.out.println("createMovie");
        return false;
    }

    public boolean updateMovie(String title, String genre, int length) {
        System.out.println("updateMovie");
        return false;
    }

    public boolean deleteMovie(String title, String genre, int length) {
        System.out.println("deleteMovie");
        return false;
    }

//    public Collection<Movie> listMovies() {
    public Movie listMovies() {
        System.out.println("listMovies");
        return new Movie("","",0);
    }
}
