package com.kajsoftware.movies.controllers;

import com.kajsoftware.movies.entities.Movie;
import com.kajsoftware.movies.controllers.request_body.MovieRequest;
import com.kajsoftware.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return this.movieService.findAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovieDetail(@PathVariable int id) {
        return this.movieService.findMovieById(id);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieRequest reqMovie) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/movies").toUriString());
        return ResponseEntity.created(uri).body(this.movieService.saveMovie(reqMovie));
    }









}
