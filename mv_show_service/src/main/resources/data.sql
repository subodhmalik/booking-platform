INSERT INTO movie (id, name, genre, active) VALUES
  (201, 'F1', 'Action', true),
  (202, 'Sitaare Zameen Par', 'Drama', true);

-- Shows
INSERT INTO show (id, name, start_time, end_time) VALUES
  (301, 'Morning', '10:00', '12:30'),
  (302, 'Matinee', '13:00', '15:30'),
  (303, 'Evening', '18:00', '20:30');

-- MovieShow: Assuming you have movie, screen, and language records in respective tables
-- Movie IDs: 101, 102; Screen IDs: 201, 202; Language IDs: 301 (English), 302 (Hindi)

INSERT INTO movie_show (id, movie_id, screen_id, show_id, language_id, show_date) VALUES
  (401, 201, 101, 301, 501, '2025-07-08'),
  (402, 201, 101, 302, 501, '2025-07-08'),
  (403, 201, 103, 301, 501, '2025-07-08'),
  (404, 202, 102, 301, 502, '2025-07-08'),
  (405, 202, 102, 302, 502, '2025-07-08'),
  (406, 202, 102, 303, 502, '2025-07-08'),
  (407, 202, 104, 301, 502, '2025-07-08'),
  (408, 202, 104, 302, 502, '2025-07-08'),
  (409, 202, 105, 303, 502, '2025-07-08');
