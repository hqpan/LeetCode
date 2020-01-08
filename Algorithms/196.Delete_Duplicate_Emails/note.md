@[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；



# 1. LeetCode 196

- 考察点：用`WHERE`子句作为限制条件，使用`DELETE`删除符合要求的行；

# 2. DELETE 语句的使用方法
- `UPDATE`：更新关系中的某个属性值；
```sql
DELETE FROM tableName
WHERE ...;
```


# 3. Solution
```sql
DELETE p1 FROM Person p1,
    Person p2 
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id; 
```



# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.