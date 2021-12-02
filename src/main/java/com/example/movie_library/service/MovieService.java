package com.example.movie_library.service;

import com.example.movie_library.model.Movie;

import java.util.List;

public interface MovieService {

     //Создает новый фильм
    public void save(Movie movie);

    //Возвращает список всех имеющихся фильмов
    public List<Movie> findAll();

    //Возвращает фильм по его ID
    public Movie findById(Long id);

     //Обновляет фильм с заданным ID,
     public void update(Long id , Movie movie);

     //Удаляет фильм с заданным ID
     public void delete(Long id);

    //Получает количество фильмов
    public long getMoviesCount();

    //Возвращает список всех фильмов по жанру
    public List<Movie> findAllByGenre(Long genreId);
}
