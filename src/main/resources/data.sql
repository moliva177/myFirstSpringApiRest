INSERT INTO players(id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES (1000000, 'APP', null, null, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO players(id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES (100, 'maxoliva', 'Password0!', 'email@email.com', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO games (id, code, name, description, rules)
VALUES (1000000, 'RPS', 'Rock Paper Scissors', 'Description', 'Rules');

INSERT INTO matches(id, game_id, player_id, created_at, updated_at, status)
VALUES (1000000, 1000000, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'STARTED');
INSERT INTO matches(id, game_id, player_id, created_at, updated_at, status)
VALUES (1000001, 1000000, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'FINISHED');
INSERT INTO matches(id, game_id, player_id, created_at, updated_at, status)
VALUES (1000002, 1000000, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CANCELED');