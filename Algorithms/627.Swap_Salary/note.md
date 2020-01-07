[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；



# 1. LeetCode 627

- 考察点：
  - `UPDATE`语句；
  - `CASE-WHEN-THEN`；



# 2. UPDATE、CASE 语句的使用方法
- `UPDATE`：更新关系中的某个属性值；
```mysql
UPDATE relationName
SET attributeName = ...;
```
- `CASE-WHEN-THEN-ELSE-END`：选择；
```mysql
CASE attributeName
	WHEN '...' THEN '...'
	WHEN '...' THEN '...'
	ELSE '...'
END;
```


# 3. Solution
```mysql
UPDATE salary 
SET 
    SEX = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END; 
```



# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.