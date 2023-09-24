package com.kajsoftware.movies.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface GenreService {
    List<String> findAllGenres() throws JsonProcessingException;

}
