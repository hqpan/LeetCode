-- Approach 1: WHERE
SELECT 
    e.Name AS Employee
FROM
    Employee AS e,
    Employee AS m
WHERE
    e.ManagerId = m.Id
        AND e.Salary > m.Salary;

-- Approach 2: INNER JOIN
inner join
SELECT 
    Employee.Name AS Employee
FROM
    Employee
        JOIN
    Employee M ON Employee.ManagerId = M.Id
WHERE
    Employee.Salary > M.Salary;

