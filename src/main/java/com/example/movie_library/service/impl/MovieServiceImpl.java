package com.example.movie_library.service.impl;

import com.example.movie_library.model.Movie;

import com.example.movie_library.repository.MovieRepository;

import com.example.movie_library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void save(Movie movie) {
movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public void update(Long id, Movie movie) {
        Movie movieFromDb = movieRepository.findById(id).get();
        movieFromDb.setFavorites(movie.isFavorites());
        movieFromDb.setGenre(movie.getGenre());
        movieFromDb.setRating(movie.getRating());
        movieFromDb.setTitle(movie.getTitle());
        movieFromDb.setReleaseDate(movie.getReleaseDate());
        movieFromDb.setViewed(movie.isViewed());
        movieRepository.save(movieFromDb);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }


    @Override
    public long getMoviesCount() {
        return movieRepository.count();
    }

    @Override
    public List<Movie> findAllByGenreId(Long categoryId) {
        return movieRepository.findAllByGenreId(categoryId);
    }
}
