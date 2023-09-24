package com.kajsoftware.movies;

import com.kajsoftware.movies.entities.Movie;
import com.kajsoftware.movies.controllers.MovieRestController;
import com.kajsoftware.movies.controllers.request_body.MovieRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MoviesApplicationTests {

	@Autowired
	private MovieRestController movieRestController;

	@Test
	public void createMovieTest() {
		MovieRequest movieRequest = new MovieRequest();
		movieRequest.setTitle("The Message!");
		movieRequest.setReleaseYear(1996);
		movieRequest.setDescription("History of spreading the word of Islam.");
		movieRequest.setGenres(Arrays.asList("Religious", "History"));

		// Bhaiya, I'm facing an issue here with GENRES
		Movie movieResponse = this.movieRestController.createMovie(movieRequest).getBody();

        assert movieResponse != null;
        assertEquals(movieRequest.getTitle(), movieResponse.getTitle());
		assertEquals(movieRequest.getReleaseYear(), movieResponse.getReleaseYear());
		assertEquals(movieRequest.getDescription(), movieResponse.getDescription());
		assertEquals(movieRequest.getGenres(), movieResponse.getGenres());

	}

	@Test
	public void getMovieDetailTest() {
		Optional<Movie> movieDetail = this.movieRestController.getMovieDetail(1);

		assertNotNull(movieDetail);
		assertEquals(1, movieDetail.get().getId());
		assertNotNull(movieDetail.get().getTitle());

	}

}
