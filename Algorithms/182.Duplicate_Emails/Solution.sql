-- Approach 1: INNER JOIN
SELECT 
    DISTINCT Person.Email
FROM 
    Person
        JOIN
    Person p ON Person.Id != p.Id
        AND Person.Email = p.Email;

-- Approach 2: GROUP BY, create temporary table
SELECT Email
FROM (
    SELECT Email, COUNT(Id) Num
    FROM Person
    GROUP BY Email
) AS count_Num
WHERE Num > 1;

-- Approach 3: GROUP BY, HAVING
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1; 
