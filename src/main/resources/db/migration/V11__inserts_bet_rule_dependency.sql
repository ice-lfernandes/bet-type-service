INSERT INTO bet_rule_dependency(idt_bet, idt_rule)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9_OVER_PLUS' AND b.is_first_half IS FALSE),
(SELECT r.idt_rule FROM rule r WHERE r.name = 'CORNER' AND r.value = 7 AND r.is_equal IS TRUE
AND r.idt_bet = (SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMIT' AND b.is_first_half IS FALSE)));
