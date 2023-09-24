package com.kajsoftware.movies.service;

import com.kajsoftware.movies.entities.Movie;
import com.kajsoftware.movies.controllers.request_body.MovieRequest;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAllMovies();
    Optional<Movie> findMovieById(long id);
    Movie saveMovie(MovieRequest movie);
    String deleteMovieById(long id);
}
