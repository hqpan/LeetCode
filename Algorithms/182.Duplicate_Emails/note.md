[TOC]

# 1. LeetCode 182

- 使用内连接；
- 使用分组，创建临时表；
- 使用分组和`HAVING`子句；



# 2. 使用内连接

```mysql
-- Approach 1: INNER JOIN
SELECT 
    DISTINCT Person.Email
FROM 
    Person
        JOIN
    Person p ON Person.Id != p.Id
        AND Person.Email = p.Email;
```



# 3. 使用分组并创建临时表

```mysql
-- Approach 2: GROUP BY, create temporary table
SELECT Email
FROM (
    SELECT Email, COUNT(Id) Num
    FROM Person
    GROUP BY Email
) AS count_Num
WHERE Num > 1;
```





# 4. 使用分组和 HAVING 子句

```mysql
-- Approach 3: GROUP BY, HAVING
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1; 
```

