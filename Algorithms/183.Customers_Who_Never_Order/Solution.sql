-- Approach 1: OUTER JOIN
SELECT Name AS Customers
FROM Customers Left JOIN Orders
ON Customers.Id = CustomerId
WHERE CustomerId IS NULL;

-- Approach 2: NOT IN
SELECT Name AS Customers
FROM Customers
WHERE Customers.Id NOT IN (
    SELECT CustomerId
    FROM Orders
);

