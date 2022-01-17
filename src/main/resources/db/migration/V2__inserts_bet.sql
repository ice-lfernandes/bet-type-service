INSERT INTO bet(name, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_green_minute, maximum_green_minute, quantity_to_green, minimum_odd,
type, is_equal, is_first_half, is_able_to_close, is_push, is_losing_required, maximum_advantage_in_result, name_balance)
VALUES ('ASIATIC', 0.50, 950, 1.00, 1000, 31, 33, 35, 35, 45, 2, 1.80, 'ALERT', 0, 1, 0, 1, 0, 2, "ASIATIC 1T");

INSERT INTO bet(name, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_green_minute, maximum_green_minute, quantity_to_green, minimum_odd,
type, is_equal, is_first_half, is_able_to_close, is_push, is_losing_required, maximum_advantage_in_result, name_balance,
idt_evict, negative_score_evict_is_push)
VALUES ('LIMIT', 0.50, 950, 1.00, 1000, 36, 38, 41, 39, 45, 1, 1.70, 'ALERT', 0, 1, 0, 0, 0, 2, "LIMIT 1T",
(SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE), -150);

INSERT INTO bet(name, minimum_unity, minimum_score, unit, score, maximum_entry_minute,
minimum_green_minute, maximum_green_minute, quantity_to_green, minimum_odd, type, is_equal, idt_parent,
is_first_half, is_able_to_close, is_push, is_losing_required, maximum_advantage_in_result, name_balance)
VALUES ('PLUS', 0.25, 1150, 0.50, 1350, 41, 39, 45, 2, 5.00, 'ANALYZABLE', 0,
(SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMIT' AND b.is_first_half IS TRUE), 1, 0, 0, 0, 2, "PLUS 1T");

INSERT INTO bet(name, name_simple, value_green, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_odd, type, is_equal, is_first_half, is_able_to_close,
maximum_check_close_minute, maximum_check_close_neutral_minute, is_push, is_losing_required, maximum_advantage_in_result, name_balance)
VALUES ('RACE_7', 'RACE', 7, 0.50, 900, 1.00, 950, 68, 73, 74, 1.72, 'ALERT', 1, 0, 1, 84, 80, 0, 0, 2, "RACE 7");

INSERT INTO bet(name, name_simple, value_green, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_odd, type, is_equal, is_first_half, is_able_to_close,
maximum_check_close_minute, maximum_check_close_neutral_minute, is_push, is_losing_required, maximum_advantage_in_result, name_balance)
VALUES ('RACE_9', 'RACE', 9, 0.50, 900, 1.00, 950, 68, 73, 74, 1.72, 'ALERT', 1, 0, 1, 84, 80, 0, 0, 2, "RACE 9");

INSERT INTO bet(name, name_simple, value_green, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_odd, type, is_equal, is_first_half, is_able_to_close,
maximum_check_close_minute, maximum_check_close_neutral_minute, idt_evict, is_push, is_losing_required,
maximum_advantage_in_result, name_balance)
VALUES ('RACE_9_PLUS', 'RACE', 9, 0.50, 950, 1.00, 1050, 80, 83, 84, 3.00, 'ALERT', 1, 0, 1, 87, 83,
(SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_9' AND b.is_first_half IS FALSE), 0, 0, 1, "RACE 9");

INSERT INTO bet(name, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_green_minute, maximum_green_minute, quantity_to_green, minimum_odd,
type, is_equal, is_first_half, is_able_to_close, is_push, is_losing_required, maximum_advantage_in_result, name_balance)
VALUES ('ASIATIC', 0.50, 950, 1.00, 1000, 81, 83, 85, 85, 90, 2, 1.80, 'ALERT', 0, 0, 0, 1, 0, 1, "ASIATIC 2T");

INSERT INTO bet(name, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_green_minute, maximum_green_minute, quantity_to_green, minimum_odd,
type, is_equal, is_first_half, is_able_to_close, is_push, is_losing_required, maximum_advantage_in_result, name_balance,
idt_evict, negative_score_evict_is_push)
VALUES ('LIMIT', 0.50, 950, 1.00, 1000, 85, 87, 91, 88, 90, 1, 1.70, 'ALERT', 0, 0, 0, 0, 0, 1, "LIMIT 2T",
(SELECT b.idt_bet FROM bet b WHERE b.name = 'ASIATIC' AND b.is_first_half IS FALSE), -150);

INSERT INTO bet(name, name_simple, value_green, minimum_unity, minimum_score, unit, score, maximum_entry_minute,
minimum_odd, type, is_equal, idt_parent, is_first_half, is_able_to_close, is_push, is_losing_required,
maximum_advantage_in_result, name_balance)
VALUES ('RACE_9_OVER_PLUS', 'RACE', 9, 0.25, 1050, 0.50, 1250, 91, 6.00, 'ANALYZABLE', 1,
(SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMIT' AND b.is_first_half IS FALSE), 0, 0, 0, 0, 1, "RACE 9");

INSERT INTO bet(name, minimum_unity, minimum_score, unit, score, maximum_entry_minute,
minimum_green_minute, maximum_green_minute, quantity_to_green, minimum_odd, type, is_equal, idt_parent,
is_first_half, is_able_to_close, is_push, is_losing_required, maximum_advantage_in_result, name_balance)
VALUES ('PLUS', 0.25, 1150, 0.50, 1350, 91, 88, 90, 2, 5.00, 'ANALYZABLE', 0,
(SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMIT' AND b.is_first_half IS FALSE), 0, 0, 0, 0, 1, "PLUS 2T");