SELECT *
FROM cinema
-- WHERE description <> "boring" AND id MOD 2 = 1
WHERE description != 'boring' AND MOD(id, 2) = 1
ORDER BY rating DESC;
