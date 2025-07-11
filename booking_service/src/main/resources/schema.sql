CREATE TABLE seat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    seat_number VARCHAR(10),
    seat_row VARCHAR(5),
    seat_zone VARCHAR(10)
);

CREATE TABLE show_seat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_show_id BIGINT,
    seat_id BIGINT,
    status VARCHAR(20),
    price DOUBLE
);

CREATE TABLE booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_show_id BIGINT,
    user_id BIGINT,
    booking_time TIMESTAMP,
    total_amount DOUBLE,
    status VARCHAR(20)
);

CREATE TABLE booking_seat_ids (
    booking_id BIGINT,
    seat_ids BIGINT
);
