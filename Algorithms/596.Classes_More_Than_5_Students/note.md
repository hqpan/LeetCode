[TOC]

# 1. LeetCode 596 ==无需复习==
- 方法一：
  - 子查询中，执行分组后对不重复的学生计数；
  - 使用`WHERE`子句筛选上课学生数量不小于5的课程;
- 方法二：
  - 对分组后的数据使用`HAVING`子句过滤；
  - 过滤条件：不重复的学生数量大于等于5；



# 2. 子查询+WHERE 子句

```mysql
SELECT class 
FROM (
    SELECT class, COUNT(DISTINCT student) AS num
    FROM courses
    GROUP BY class
) AS auxTable
WHERE num >= 5; 
```



# 3. HAVING 子句

- 注意：聚集函数`COUNT()`中可使用`DISTINCT`关键字，统计不重复的元素数量；

```mysql
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
```

