[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 45

## 1.1 复杂度分析

- 自定义比较器排序：
  - 时间复杂度：$O(logn)$；
  - 空间复杂度：$O(n)$；

## 1.2 自定义比较器排序

### 1.2.1 解题思路

- 解题思路：
  - 本题的实质是一个排序问题，需要根据特定的规则，将数组中的数值排序，使得数组中的数排列为最小的数；
  - 比较规则如下：E.g. {3, 23}；
    - 将所有整型转换为字符串；
    - 按字典序为字符串排序，即可排列得到最小的数；

### 1.2.2 用函数实现比较器

- 用函数实现自定义比较器：被排序的数组必须为引用数据类型，不能为基本数据类型；

```java
// Approach 1: Function
class Solution {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String str : strs)
            builder.append(str);
        return builder.toString();
    }
}
```

### 1.2.3 用Lambda表达式实现比较器

- 用 Lambda 表达式实现自定义比较器：被排序的数组必须为引用数据类型，不能为基本数据类型；

```java
// Approach 2: Lambda
class Solution {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }
}
```

# 2. Summary

## 2.1 Grammar

- 用函数实现自定义比较器：被排序的数组必须为引用数据类型，不能为基本数据类型；

```java
Arrays.sort(strs, new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });
```

- 用 Lambda 表达式实现自定义比较器：被排序的数组必须为引用数据类型，不能为基本数据类型；

```java
Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
```

## 2.2 算法设计

- 参见 LeetCode 45 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.