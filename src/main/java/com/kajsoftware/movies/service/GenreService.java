package com.kajsoftware.movies.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kajsoftware.movies.entities.Genre;
import com.kajsoftware.movies.entities.Movie;
import com.kajsoftware.movies.restControllers.request_body.MovieRequest;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<String> findAllGenres() throws JsonProcessingException;

}
