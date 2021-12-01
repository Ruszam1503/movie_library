package com.example.movie_library.service;

import com.example.movie_library.model.Movie;

import java.math.BigDecimal;
import java.util.Map;

public interface MovieCartService {
    void addMovie(Movie movie);

    void removeMovie(Movie movie);

    void clearMovie();

    void cartCheckout();

    Map<Movie, Integer> getMovieInCart();

    int countMovies();
}
