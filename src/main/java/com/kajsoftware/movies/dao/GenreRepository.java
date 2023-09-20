package com.kajsoftware.movies.dao;

import com.kajsoftware.movies.entities.Genre;
import com.kajsoftware.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
