[TOC]

# 1. LeetCode 197 ==无需复习==

- 考察点：
  - 内连接;
  - `DATEDIFF(date1, date2)`：返回两个日期相差的天数；

```sql
SELECT 
    Weather.Id
FROM
    Weather
        JOIN
    Weather t1 ON DATEDIFF(Weather.RecordDate, t1.RecordDate) = 1
        AND Weather.Temperature > t1.Temperature;
```