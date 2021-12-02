package com.example.movie_library.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "genres")
public class Genre {

        @Column(name = "genre_id")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "genre_name")
        @NotNull
        @NotEmpty
        private String genre;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre", cascade = CascadeType.ALL)
        private Set<Movie> movies = new HashSet<>();

        public Genre(long id, String genre, Set<Movie> movies) {
                this.id = id;
                this.genre = genre;
                this.movies = movies;
        }

        public Genre() {
        }

        @Override
        public String toString() {
                return "Genre{" +
                        "id=" + id +
                        ", genre='" + genre + '\'' +
                        ", movies=" + movies +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Genre genre1 = (Genre) o;
                return id == genre1.id && Objects.equals(genre, genre1.genre) && Objects.equals(movies, genre1.movies);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, genre, movies);
        }
}

