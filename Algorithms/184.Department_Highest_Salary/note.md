[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 184
- 考察点：
  - 内连接；
  - 集合成员资格查询：`IN`;
  - 对分组应用聚合函数：`MAX()`；



# 2. 具体实现

```sql
SELECT 
    Department.Name AS Department, 
    Employee.Name AS Employee, 
    Salary
FROM 
    Employee 
        JOIN 
    Department ON DepartmentId = Department.Id
WHERE (DepartmentId, Salary) IN 
    (
        SELECT 
            DepartmentId, MAX(Salary)
        FROM 
            Employee
        GROUP BY DepartmentId
    );
```

# 3. 错误解答分析
- 如下所示，`SELECT`子句中的`Name`将返回每个分组中的第一个雇员姓名，而`MAX(Salary)`将返回每个分组中最高薪资，因此不满足题意；
- 经验：未出现在`GROUP BY`子句中的列名，应作为`SELECT`子句中的聚合函数参数，而非直接置于`SELECT`子句中，否则返回结果无实际意义；
```sql
SELECT DepartmentId, Name, MAX(Salary)
FROM Employee
GROUP BY DepartmentId;
```

# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.