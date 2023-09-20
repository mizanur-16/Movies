package com.kajsoftware.movies.service;

import com.kajsoftware.movies.dao.MovieRepository;
import com.kajsoftware.movies.entities.Movie;
import com.kajsoftware.movies.restControllers.exception_handler.MovieNotFoundException;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService{

    public MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        Optional<Movie> result = this.movieRepository.findById(id);

        Movie theMovie = null;

        if (result.isPresent()) {
            theMovie = result.get();
        } else {
            throw new MovieNotFoundException("Movie id: " + id + " NOT FOUND");
        }
        return Optional.of(theMovie);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public String deleteMovieById(int id) {
        this.movieRepository.deleteById(id);
        return "Movie id: " + id + " DELETED";
    }
}
