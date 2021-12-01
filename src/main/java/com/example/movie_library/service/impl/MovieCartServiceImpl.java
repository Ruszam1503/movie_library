package com.example.movie_library.service.impl;

import com.example.movie_library.model.Movie;
import com.example.movie_library.service.MovieCartService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class MovieCartServiceImpl implements MovieCartService {
    private Map<Movie, Integer> movies = new HashMap<>();

    @Override
    public void addMovie(Movie movie) {
        if (movies.containsKey(movie)) {
            movies.replace(movie, movies.get(movie));
        } else {
            movies.put(movie, 1);

        }
    }

    @Override
    public void removeMovie(Movie movie) {
            if (movies.containsKey(movie)) {
                movies.remove(movie);
                }
            }

    @Override
    public void clearMovie() {
        movies.clear();
    }

    @Override
    public void cartCheckout() {
        movies.clear();
    }


    @Override
    public Map<Movie, Integer> getMovieInCart() {
       return Collections.unmodifiableMap(movies);
    }

    @Override
    public int countMovies() {
        return movies.size();
    }

}

