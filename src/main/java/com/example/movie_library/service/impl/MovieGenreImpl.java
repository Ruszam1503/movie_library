package com.example.movie_library.service.impl;

import com.example.movie_library.model.Genre;
import com.example.movie_library.model.Movie;
import com.example.movie_library.repository.GenreRepository;
import com.example.movie_library.service.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreImpl implements MovieGenre {

    private  final GenreRepository genreRepository;

    @Autowired
    public MovieGenreImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
