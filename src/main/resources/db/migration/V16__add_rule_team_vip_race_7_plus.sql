INSERT INTO rule(idt_bet, idt_parent, type, name)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_7_PLUS'),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CHECK_TEAM_VIP'),
'ANALYZED', 'TEAM_VIP');