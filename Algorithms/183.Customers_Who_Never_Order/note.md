[TOC]

# 1. LeetCode 183 ==无需复习==
- 考察点：
  - 执行外连接后，使用`WHERE`子句筛选;
  - 集合成员资格查询：`NOT IN`，适用于一行或一列；



# 2. 外连接

```mysql
-- Approach 1: OUTER JOIN
SELECT Name AS Customers
FROM Customers Left JOIN Orders
ON Customers.Id = CustomerId
WHERE CustomerId IS NULL;
```



# 3. 集合成员资格查询

```mysql
-- Approach 2: NOT IN
SELECT Name AS Customers
FROM Customers
WHERE Customers.Id NOT IN (
    SELECT CustomerId
    FROM Orders
);
```

