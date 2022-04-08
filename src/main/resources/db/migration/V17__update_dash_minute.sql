UPDATE bet b
SET b.minimum_dash_minute = 20, b.maximum_dash_minute = 29
WHERE b.name = 'ASIATIC' AND b.is_first_half IS TRUE;

UPDATE bet b
SET b.minimum_dash_minute = 30, b.maximum_dash_minute = 37
WHERE b.name = 'LIMIT' AND b.is_first_half IS TRUE;

UPDATE bet b
SET b.minimum_dash_minute = 60, b.maximum_dash_minute = 74
WHERE b.name = 'RACE_7';

UPDATE bet b
SET b.minimum_dash_minute = 60, b.maximum_dash_minute = 74
WHERE b.name = 'RACE_9';

UPDATE bet b
SET b.minimum_dash_minute = 75, b.maximum_dash_minute = 81
WHERE b.name = 'RACE_7_PLUS';

UPDATE bet b
SET b.minimum_dash_minute = 75, b.maximum_dash_minute = 81
WHERE b.name = 'RACE_9_PLUS';

UPDATE bet b
SET b.minimum_dash_minute = 75, b.maximum_dash_minute = 81
WHERE b.name = 'ASIATIC' AND b.is_first_half IS FALSE;

UPDATE bet b
SET b.minimum_dash_minute = 82, b.maximum_dash_minute = 87
WHERE b.name = 'LIMIT' AND b.is_first_half IS FALSE;