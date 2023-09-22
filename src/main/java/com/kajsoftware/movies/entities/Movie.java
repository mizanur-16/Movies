package com.kajsoftware.movies.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "movie")
public class Movie {
    // Defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseYear")
    private int releaseYear;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @JsonIgnore  // IT INDICATES THAT THE FOLLOWING PROPERTY SHOULD BE IGNORED DURING SERIALIZATION
    private List<Genre> genres;

    public Movie() {
    }

    public Movie(String title, int releaseYear, String description) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.description = description;
    }

    @JsonProperty("genres") // @JsonProperty TO SPECIFY THAT IT SHOULD BE SERIALIZED AS "genres"
    public List<String> getGenreNames() {
        // Extract genre names from the list of Genre objects
        return genres.stream().map(Genre::getName).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", description='" + description + '\'' +
                ", genres=" + genres +
                '}';
    }
}
