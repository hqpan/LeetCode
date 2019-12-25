[TOC]

# 1. LeetCode 595 ==无需复习==
- 使用关键字`OR`：
- 使用关键字`UNION`：语句冗长;

# 2. 使用关键字`OR`
```sql
-- Approach 1: or
select name, population, area
from World
where area > 3000000 or population > 25000000;
```

# 3. 使用关键字`UNION`
```sql
-- Approach 2: union
select name, population, area
from World
where area > 3000000
union
select name, population, area
from World
where population > 25000000;
```
