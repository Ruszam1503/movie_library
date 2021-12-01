package com.example.movie_library.repository;

import com.example.movie_library.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByGenreId(Long categoryId);
}
