package com.kajsoftware.movies.restControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kajsoftware.movies.entities.Genre;
import com.kajsoftware.movies.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreRestController {

    private final GenreService genreService;

    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() throws JsonProcessingException {
        return this.genreService.findAllGenres();
    }




}
