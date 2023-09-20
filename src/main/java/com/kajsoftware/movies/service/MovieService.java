package com.kajsoftware.movies.service;

import com.kajsoftware.movies.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAllMovies();
    Optional<Movie> findMovieById(int id);
    Movie createMovie(Movie movie);
    String deleteMovieById(int id);
}
