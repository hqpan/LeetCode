[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 181

- 考察点：内连接的三种方式；
  - `WHERE`子句：`SELECT-FROM`语句生成笛卡尔积，然后使用`WHERE`子句筛选结果；
  - `INNER-JOIN-ON`：根据`ON`子句中的条件执行内连接；
  - `NATURAL JOIN`：自然连接只能匹配两张表中的同名列，因此不适用于本题；

# 2. WHERE 子句
```sql
-- Approach 1: WHERE
SELECT 
    e.Name AS Employee
FROM
    Employee AS e,
    Employee AS m
WHERE
    e.ManagerId = m.Id
        AND e.Salary > m.Salary;
```

# 3. INNER-JOIN-ON
```sql
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
```

# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.