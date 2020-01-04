-- Approach 1
SELECT class 
FROM (
    SELECT class, COUNT(DISTINCT student) AS num
    FROM courses
    GROUP BY class
) AS auxTable
WHERE num >= 5; 

-- Approach 2
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
