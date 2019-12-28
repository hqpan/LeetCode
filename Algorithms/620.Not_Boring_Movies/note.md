[TOC]

# 1. LeetCode 620 ==无需复习==
- 考察点：查询条件、排序;

```sql
SELECT *
FROM cinema
-- WHERE description <> "boring" AND id MOD 2 = 1
WHERE description != "boring" AND MOD(id, 2) = 1
ORDER BY rating DESC;
```

