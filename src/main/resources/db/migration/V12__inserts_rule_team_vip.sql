INSERT INTO rule(type, name)
VALUES ('ANALYSIS', 'CHECK_TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMIT' AND b.is_first_half IS TRUE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_7'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS FALSE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');

INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMIT' AND b.is_first_half IS FALSE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');