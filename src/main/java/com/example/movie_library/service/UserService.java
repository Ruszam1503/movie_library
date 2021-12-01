package com.example.movie_library.service;
import com.example.movie_library.model.Movie;
import com.example.movie_library.model.User;

import java.util.List;

public interface UserService {

    //Сохраняет нового пользователя
    public void save(User user);

    //Возвращает список всех имеющихся пользователей
    public List<User> findAll();

    //Возвращает пользователя по его ID
    public User findById(Long id);

    //Обновляет пользователя с заданным ID,
    public void update(Long id , User user);

    //Удаляет пользователя с заданным ID
    public void delete(Long id);

    //Получает количество пользователей
    public Integer getUsersCount();

    //Возвращает пользователя по его имени
    public User findByName(String username);

    //Возвращает пользователя по его емейлу
    public User findByEmail(String email);

    //Возвращает залогиненого пользователя
    public void login(String username, String password);
}
