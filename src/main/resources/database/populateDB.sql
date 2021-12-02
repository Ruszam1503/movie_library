INSERT INTO users (user_id, name, email, password )
VALUES (1, 'User', 'user@yandex.ru', 222 ),
       (2, 'Admin', 'admin@gmail.com', 333);

INSERT INTO genres (genre_id, genre_name)
VALUES (1, '1'),
       (2, '2');

INSERT INTO movies (title, genres_id, rating, release_date, favorites, viewed)
VALUES ('Крестный отец' ,'1' , 10,'1970-01-30 13:00:00', true, true ),
       ('Крепкий орешек' ,'1' , 7,'1998-01-30 13:00:00', false, true ),
       ('Один дома','2' , 6,'1991-01-30 13:00:00', true, false ),
       ('Матрица','2' , 10,'1999-01-30 13:00:00', false, true ),
       ('Титаник','2' , 4,'1998-01-30 13:00:00', true, false );
