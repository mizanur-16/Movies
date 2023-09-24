package com.kajsoftware.movies.dao;

import com.kajsoftware.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie, Long> {
    // That's it, No need to write any further code
}
