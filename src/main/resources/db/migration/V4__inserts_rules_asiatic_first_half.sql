INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'BALL_POSSESSION', 60, 50, 1, 1, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'BALL_POSSESSION', 65, 250, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'BALL_POSSESSION', 70, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'BALL_POSSESSION', 75, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'CORNER', 2, 100, 1, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'CORNER', 3, 100, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'CORNER', 4, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'CORNER', 5, 100, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'KICK', 5, 50, 1, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'KICK', 6, 150, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'KICK', 8, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'KICK', 10, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'KICK', 12, 50, 0, 0, 0, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'RED_CARD', 1, 250, 0, 0, 1, 0);

INSERT INTO rule(idt_bet, type, name, value, score, is_mandatory, is_mandatory_after_red_card, is_underdog_team, is_equal)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
'ALERT', 'RED_CARD', 2, 350, 0, 0, 1, 0);

INSERT INTO rule(idt_bet, idt_parent, type, name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_RESULT'),
'ANALYZED', 'FAVORITE_TEAM_LOSING', 300);

INSERT INTO rule(idt_bet, idt_parent, type, name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_RESULT'),
'ANALYZED', 'FAVORITE_TEAM_TYING', 150);

INSERT INTO rule(idt_bet, idt_parent, type, name, value, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_CORNER_FREQUENCY'),
'ANALYZED', 'NONE_CORNER_MINUTE', 10, -50);

INSERT INTO rule(idt_bet, idt_parent, type, name, value, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_CORNER_FREQUENCY'),
'ANALYZED', 'NONE_CORNER_MINUTE', 20, -100);