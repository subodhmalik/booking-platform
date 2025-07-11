CREATE TABLE theatre (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE screen (
    id IDENTITY PRIMARY KEY,
    screen_name VARCHAR(255),
    theatre_id BIGINT,
    FOREIGN KEY (theatre_id) REFERENCES theatre(id)
);