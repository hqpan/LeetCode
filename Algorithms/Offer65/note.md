[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 65

## 1.1 复杂度分析

- 位运算：
  
  - 时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)$；
- 相似的题：在不定义新变量的情况下，交换 2 个变量的值；
  - Approach 1：基于加减法实现变量交换；
    - $a=a+b$；
    - $b=a-b$；
    - $a=a-b$；
  - Approach 2：基于异或运算实现变量交换；
    - $a=a\wedge b$；
    - $b=a\wedge b$；
    - $a=a\wedge b$；

## 1.2 位运算

- 解题思路：
  - 由题意可知，不得使用四则运算，则考虑位运算；
  - 异或：实现无进位加法器；
  - 按位与、左移 1 位：记录进位；
  - 循环：将无符号加法计算结果、进位结果累加（即重复上述模拟加法运算），直至进位结果为 0，即为所求；
- 难点：`<<`不改变符号位；

```java
class Solution {
    public int add(int a, int b) {
        int sum = 0;
        int carry = 0;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (carry != 0);
        return sum;
    }
}
```

# 2. Summary

## 2.1 Grammar

- `<<`不改变符号位；
- `do...while`的语法格式：

```java
do {
    // ...
} while (...);
```

## 2.2 算法设计

- 参见剑指 Offer 65 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.