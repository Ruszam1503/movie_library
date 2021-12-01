package com.example.movie_library.repository;

import com.example.movie_library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
//    Genre findByGenreName(String name);
}
