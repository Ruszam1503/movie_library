package com.example.movie_library.service;

import com.example.movie_library.model.Genre;
import com.example.movie_library.model.Movie;

import java.util.List;

public interface MovieGenre {

    public void save(Genre genre);

    public List<Genre> findAll();
}
