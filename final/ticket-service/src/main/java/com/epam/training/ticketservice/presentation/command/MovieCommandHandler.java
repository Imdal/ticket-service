package com.epam.training.ticketservice.presentation.command;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.service.MovieService;
import com.epam.training.ticketservice.service.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class MovieCommandHandler {
    private MovieService movieService;
    private UserService userService;


    public MovieCommandHandler(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }

    @ShellMethod(value = "Create movie", key = "create movie")
    public void createMovie(String title, String genre, int length) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            movieService.createMovie(title, genre, length);
        }
    }

    @ShellMethod(value = "Update movie", key = "update movie")
    public void updateMovie(String title, String genre, int length) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            movieService.updateMovie(title, genre, length);
        }
    }

    @ShellMethod(value = "Delete movie", key = "delete movie")
    public void deleteMovie(String title) {
        if (userService.isUserSignedIn() && userService.describeAccount().getAccountType().equals("admin")) {
            movieService.deleteMovie(title);
        }
    }

    @ShellMethod(value = "List movies", key = "list movies")
    public String listMovies() {
        List<Movie> movieList = movieService.listMovies();
        String result = "";
        if (movieList.isEmpty()) {
            result = "There are no movies at the moment";
        } else {
            for (Movie movie: movieList) {
                result +=  toStringMovie(movie) + "\n";
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public String toStringMovie(Movie movie) {
        return movie.getTitle() + " (" + movie.getGenre() + ", " + movie.getLength() + " minutes)";
    }

}
