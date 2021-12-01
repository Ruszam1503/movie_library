package com.example.movie_library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {


    @Id
    @Column(name = "movie_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre", nullable = true)
    private Genre genre;

    @Column(name = "rating", nullable = false)
    @Min(1)
    @Max(10)
    private double rating;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "favorites", nullable = false)
    private boolean favorites;

    @Column(name = "viewed", nullable = false)
    private boolean viewed;


    public Movie(Long id, String title, Genre genre, double rating, Date releaseDate, boolean favorites, boolean viewed) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.favorites = favorites;
        this.viewed = viewed;
    }

    public Movie(){

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "rating = " + rating + ", " +
                "releaseDate = " + releaseDate + ", " +
                "favorites = " + favorites + ", " +
                "viewed = " + viewed + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.rating, rating) == 0 && favorites == movie.favorites && viewed == movie.viewed && Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre) && Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, rating, releaseDate, favorites, viewed);
    }
}
