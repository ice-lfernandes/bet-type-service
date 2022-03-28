INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'BALL_POSSESSION', 60, 50, 1, 1, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'BALL_POSSESSION', 65, 250, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'BALL_POSSESSION', 70, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'BALL_POSSESSION', 75, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'CORNER', 7, 250, 1, 1, 0, 1);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'SHOTS_ON_TARGET', 4, 0, 1, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'KICK', 10, 150, 1, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'KICK', 12, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'KICK', 14, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'KICK', 16, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'KICK', 18, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'RED_CARD', 0, 250, 0, 0, 1, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
'ALERT', 'RED_CARD', 1, 350, 0, 0, 1, 0);

INSERT INTO rule(idt_bet, idt_parent, type, name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_RESULT'),
'ANALYZED', 'FAVORITE_TEAM_TYING', 200);

INSERT INTO rule(idt_bet, idt_parent, type, name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_RESULT'),
'ANALYZED', 'FAVORITE_TEAM_LOSING', 350);

INSERT INTO rule(idt_bet, idt_parent, type, name, value, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_CORNER_FREQUENCY'),
'ANALYZED', 'NONE_CORNER_MINUTE', 10, -50);

INSERT INTO rule(idt_bet, idt_parent, type, name, value, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_CORNER_FREQUENCY'),
'ANALYZED', 'NONE_CORNER_MINUTE', 20, -50);

INSERT INTO rule(idt_bet, idt_parent, type, name, value, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_CORNER_FREQUENCY'),
'ANALYZED', 'NONE_CORNER_MINUTE', 30, -100);

INSERT INTO rule(idt_bet, idt_parent, type, name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_LEAGUE_TYPE'),
'ANALYZED', 'IS_CUP', 50);