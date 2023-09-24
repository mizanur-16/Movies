package com.kajsoftware.movies.service;

import com.kajsoftware.movies.dao.GenreRepository;
import com.kajsoftware.movies.dao.MovieRepository;
import com.kajsoftware.movies.entities.Genre;
import com.kajsoftware.movies.entities.Movie;
import com.kajsoftware.movies.controllers.exception_handler.MovieNotFoundException;
import com.kajsoftware.movies.controllers.request_body.MovieRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    public MovieRepository movieRepository;
    public GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
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
    public Movie saveMovie(MovieRequest requestBody) {
        Movie newMovie = new Movie();
        newMovie.setTitle(requestBody.getTitle());
        newMovie.setDescription(requestBody.getDescription());
        newMovie.setReleaseYear(requestBody.getReleaseYear());

        List<Genre> genres = new ArrayList<>();

        if (!requestBody.getGenres().isEmpty()) {
            for (String genreName : requestBody.getGenres()) {
                // CHECKING IF THE GENRE EXISTS IN THE DATABASE
                Genre existingGenre = this.genreRepository.findByName(genreName);

                if (existingGenre != null) {
                    // IF EXISTS IN THE DATABASE
                    genres.add(existingGenre);
                } else {
                    // IF NOT EXISTS
                    Genre newGenre = new Genre();
                    newGenre.setName(genreName);

                    this.genreRepository.save(newGenre);
                    genres.add(newGenre);
                }
            }
        }

        newMovie.setGenres(genres);

        return this.movieRepository.save(newMovie);
    }

    @Override
    public String deleteMovieById(int id) {
        this.movieRepository.deleteById(id);
        return "Movie id: " + id + " DELETED";
    }
}
