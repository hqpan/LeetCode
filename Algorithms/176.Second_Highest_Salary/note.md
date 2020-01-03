[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 176
- 考察点：
  - 降序排列后，使用`LIMIT`筛选输出结果，使用`IF-NULL`在查询无结果时返回`NULL`;
  - 子查询：使用子查询返回特定结果，应用`SELECT-AS`在查询无结果时返回`NULL`;



# 2. 降序排列

```sql
-- Approach 1: IFNULL, LIMIT
SELECT 
    IFNULL((SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1 , 1),
            NULL) AS SecondHighestSalary;
```



# 3. 子查询

```sql
-- Approach 2: temporary table
SELECT (
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1)
    AS SecondHighestSalary;
```


# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.