INSERT INTO users (user_id, name, email, password )
VALUES (1, 'User', 'user@yandex.ru', 222 ),
       (2, 'Admin', 'admin@gmail.com', 333);

INSERT INTO genres (genre_id, genre_name)
VALUES (1, 'horror'),
       (2, 'drama');

INSERT INTO movies (title, genre, rating, release_date, favorites, viewed)
VALUES ('Крестный отец' ,'THRILLER' , 10,'1970-01-30 13:00:00', true, true ),
       ('Крепкий орешек' ,'ACTION' , 7,'1998-01-30 13:00:00', false, true ),
       ('Один дома','COMEDY' , 6,'1991-01-30 13:00:00', true, false ),
       ('Матрица','FANTASY' , 10,'1999-01-30 13:00:00', false, true ),
       ('Титаник','ROMANCE' , 4,'1998-01-30 13:00:00', true, false );
