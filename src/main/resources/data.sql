INSERT INTO players(id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES (1000000, 'APP', null, null, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO players(id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES (100, 'maxoliva', 'Password0!', 'email@email.com', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO games (id, code, name, description, rules)
VALUES (1000000, 'RPS', 'Rock Paper Scissors', 'Description', 'Rules');

INSERT INTO matches(id, game_id, player1_id, player2_id, created_at, updated_at, status)
VALUES (1000000, 1000000, 100, 1000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'STARTED');
INSERT INTO matches(id, game_id, player1_id, player2_id,  created_at, updated_at, status)
VALUES (1000001, 1000000, 100, 1000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'FINISHED');
INSERT INTO matches(id, game_id, player1_id, player2_id,  created_at, updated_at, status)
VALUES (1000002, 1000000, 100, 1000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CANCELED');

INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
VALUES (1000000, 10, 5, 3, 2);
INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score, winner_id)
VALUES (1000001, 10, 0, 6, 4, 100);
INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
VALUES (1000002, 10, 5, 3, 2);

INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000000, 1000000, 'ROCK', 'PAPER', 1000000);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000001, 1000000, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000002, 1000000, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000003, 1000000, 'ROCK', 'SCISSORS', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000004, 1000000, 'ROCK', 'PAPER', 1000000);

INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000010, 1000001, 'ROCK', 'PAPER', 1000000);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000011, 1000001, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000012, 1000001, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000013, 1000001, 'ROCK', 'SCISSORS', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000014, 1000001, 'ROCK', 'PAPER', 1000000);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000015, 1000001, 'ROCK', 'PAPER', 1000000);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000016, 1000001, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000017, 1000001, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000018, 1000001, 'ROCK', 'SCISSORS', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000019, 1000001, 'ROCK', 'PAPER', 1000000);

INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000020, 1000002, 'ROCK', 'PAPER', 1000000);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000021, 1000002, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000022, 1000002, 'PAPER', 'ROCK', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000023, 1000002, 'ROCK', 'SCISSORS', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000024, 1000002, 'ROCK', 'PAPER', 1000000);