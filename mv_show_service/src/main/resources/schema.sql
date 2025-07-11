CREATE TABLE movie (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    genre VARCHAR(100),
    active BOOLEAN
);

CREATE TABLE show (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    start_time TIME,
    end_time TIME
);

CREATE TABLE movie_show (
    id IDENTITY PRIMARY KEY,
    movie_id BIGINT,
    screen_id BIGINT,
    show_id BIGINT,
    language_id BIGINT,
    show_date DATE,
    FOREIGN KEY (show_id) REFERENCES show(id)
);