[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 8 & 剑指 Offer 67

## 1.1 复杂度分析

- 遍历字符串：
  
  - 时间复杂度：$O(n)$；
  
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 67；

## 1.2 遍历字符串

- 解题思路：
  - 由题意可知，遍历字符串，逐个字符处理即可；
  - 使用`trim()`函数去除字符串首尾空格；
  - 定义变量`sign`保存符号位特征，若后续字符为`+`、`-`，则将`sign`设置为 1、-1；
  - 将**后续字符**中连续的**数值字符**转换为**数值**；
- 难点：对特殊情况的检测；
  - 字符串为空；
  - 字符串长度为 0；
  - 字符串符号位后无数值；
  - 使用`charAt()`函数遍历字符串越界；
  - `int`、`long`保存结果越界；

```java
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0)
            return 0;
        String tempStr = str.trim();
        int index = 0;
        int sign = 1;
        if (tempStr.charAt(0) == '+')
            index++;
        else if (tempStr.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        long res = 0;
        while (index < tempStr.length() && '0' <= tempStr.charAt(index) && tempStr.charAt(index) <= '9') {
            int bit = tempStr.charAt(index) - '0';
            res = 10 * res + bit;
            index++;
            if (res > Integer.MAX_VALUE)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign == 1 ? (int) res : - (int) res;
    }
} 
```

# 2. Summary

## 2.1 Grammar

- 对`String`变量赋值：
  - `String`指向的内容不可变，但`String`中存储的对象引用是可变的；
  - E.g. `String str = "aaa";   str = "bbb";`；
  - 对`String`变量赋值的实质是，在内存中开辟新的空间保存新的字符串值，将`String`变量的引用指向新的内存空间；
- `java.lang.String`：`public char charAt(int index)`，索引从 0 开始；
- 难点：对特殊情况的检测；
  - 字符串为空；
  - 字符串长度为 0；
  - 字符串符号位后无数值；
  - 使用`charAt()`函数遍历字符串越界；
  - `int`、`long`保存结果越界；

## 2.2 算法设计

- ==无需复习==

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.