DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS genres;

CREATE TABLE users
(
    user_id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR  NOT NULL,
    email          VARCHAR  NOT NULL,
    password          VARCHAR  NOT NULL
);

CREATE TABLE movies
(
    movie_id             BIGSERIAL PRIMARY KEY,
    title           VARCHAR(30)  NOT NULL,
    genre          VARCHAR(30)  NOT NULL,
    rating  NUMERIC   NOT NULL,
    release_date TIMESTAMP  NOT NULL,
    favorites BOOLEAN  NOT NULL,
    viewed BOOLEAN  NOT NULL
);

CREATE TABLE genres
(
    genre_id             BIGSERIAL PRIMARY KEY,
    genre_name           VARCHAR(30)  NOT NULL
);
