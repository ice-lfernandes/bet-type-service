INSERT INTO bet(name, name_simple, value_green, minimum_unity, minimum_score, unit, score, minimum_alert_minute,
maximum_alert_minute, maximum_entry_minute, minimum_odd, type, is_equal, is_first_half, is_able_to_close,
maximum_check_close_minute, maximum_check_close_neutral_minute, idt_evict, is_push, is_losing_required,
maximum_advantage_in_result, name_balance, is_plus, automation_line, is_enabled)
VALUES ('RACE_7_PLUS', 'RACE', 7, 0.50, 950, 1.00, 1050, 80, 83, 84, 3.00, 'ALERT', 1, 0, 1, 87, 83,
(SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE_7' AND b.is_first_half IS FALSE), 0, 1, 1, "RACE 7", 0, 2.00, 1);
