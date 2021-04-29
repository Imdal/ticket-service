package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class MovieCommandHandler {
    private MovieService movieService;

    public MovieCommandHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    @ShellMethod(value = "Create movie", key = "create movie")
    public void createMovie(String title, String genre, int length) {
        movieService.createMovie(title, genre, length);
    }

    @ShellMethod(value = "Update movie", key = "update movie")
    public void updateMovie(String title, String genre, int length) {
        movieService.updateMovie(title, genre, length);
    }

    @ShellMethod(value = "Delete movie", key = "delete movie")
    public void deleteMovie(String title, String genre, int length) {
        movieService.deleteMovie(title, genre, length);
    }

    @ShellMethod(value = "List movies", key = "list movies")
    public void listMovies() {
        List<Movie> movieList = movieService.listMovies();
        if(movieList.isEmpty())
            System.out.println("There are no movies at the moment");
        else
            System.out.println(movieList.toString());
    }

}
