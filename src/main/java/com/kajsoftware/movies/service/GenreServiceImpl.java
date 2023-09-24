package com.kajsoftware.movies.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kajsoftware.movies.dao.GenreRepository;
import com.kajsoftware.movies.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    public GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<String> findAllGenres() throws JsonProcessingException {
        List<Genre> genres = this.genreRepository.findAll();

        // EXTRACT AND RETURN GENRE NAMES FROM THE LIST OF GENRE OBJECTS
        return genres.stream().map(Genre :: getName).collect(Collectors.toList());
    }



}
