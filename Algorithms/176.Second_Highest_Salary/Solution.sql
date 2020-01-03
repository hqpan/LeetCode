-- Approach 1: IFNULL, LIMIT
SELECT 
    IFNULL((SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1 , 1),
            NULL) AS SecondHighestSalary;

-- Approach 2: temporary table
SELECT (
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1)
    AS SecondHighestSalary;

