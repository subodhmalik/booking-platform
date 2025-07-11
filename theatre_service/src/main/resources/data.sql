-- Insert Theatres
INSERT INTO theatre (id, name, location) VALUES
  (1, 'PVR Connaught Place', 'Delhi'),
  (2, 'INOX South City', 'Gurgaon');

-- Insert Screens
INSERT INTO screen (id, screen_name, theatre_id) VALUES
  (101, 'Europa 1', 1),
  (102, 'Europa 2', 1),
  (103, 'Audi 1', 2),
  (104, 'Audi 2', 2),
  (105, 'Audi 3', 2),
  (106, 'Audi 4', 2);
