INSERT INTO users (user_id, name, email, password )
VALUES (1, 'User', 'user@yandex.ru', 222 ),
       (2, 'Admin', 'admin@gmail.com', 333);

INSERT INTO genres (genre_id, genre_name)
VALUES (1, 'Триллер'),
       (2, 'Боевик'),
       (3, 'Семейный'),
       (4, 'Фантастика'),
       (5, 'Драма');

INSERT INTO movies (movie_id, title, genres_id, rating, release_date, favorites, viewed)
VALUES (1, 'Крестный отец' ,'1' , 10,'1970-01-30 13:00:00', true, true ),
       (2, 'Крепкий орешек' ,'2' , 7,'1998-01-30 13:00:00', false, true ),
       (3, 'Один дома','3' , 6,'1991-01-30 13:00:00', true, false ),
       (4, 'Матрица','4' , 10,'1999-01-30 13:00:00', false, true ),
       (5, 'Титаник','5' , 4,'1998-01-30 13:00:00', true, false );
