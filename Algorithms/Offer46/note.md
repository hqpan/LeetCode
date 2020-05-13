[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 46

## 1.1 复杂度分析

- 遍历字符串：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$，数值转换为字符串后占用的空间；
- 数值取余：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 1.2 遍历字符串

- 解题思路：DP 问题；
  - 递归分析：对于每一位数值，有2种翻译方法；
    - 将当前数值单独翻译为字符串；
    - 若前一数值和当前数值组成的数在$[10,25]$区间内，则可将2个数一并翻译为字符串；
  - 迭代求解：
    - 状态定义：$dp[i]$表示以$bit_i$结尾的数值对应的翻译方案数量；
    - 状态转移方程：
      - 若$10\leq bit_{i-1}bit_i\leq 25$，则$dp[i]=dp[i-2]+dp[i-1]$；
      - 否则$dp[i]=dp[i-1]$；
    - 初始状态：
      - $dp[0]=1,dp[1]=1$；
      - 此处定义$dp[0]$是为了便于计算$dp[2]$，当$bit_1$、$bit_2$可合并翻译时，需要使用$dp[0]$；
  - 优化：考虑到$dp[i]$仅与$dp[i-2]$、$dp[i-1]$有关，因此使用滚动数组节省$dp[]$数组的空间开销；

```java
// Approach 1: 遍历字符串
class Solution {
    public int translateNum(int num) {
        if (num < 0)
            throw new RuntimeException("Invalid input!");
        String str = String.valueOf(num);
        int step2 = 1;
        int step1 = 1;
        int res = 1;
        for (int i = 2; i <= str.length(); i++) {
            int value = Integer.parseInt(str.substring(i - 2, i));
            res = (10 <= value && value <= 25) ? step2 + step1 : step1;
            step2 = step1;
            step1 = res;
        }
        return res;
    }
}
```

## 1.3 数值取余

- 解题思路：
  - 由题意可知，翻译方案仅需考虑当前位、当前位和相邻位组合翻译的情况，因此从左向右、从右向左翻译，翻译方案总数相同；
  - 考虑到遍历字符串中，字符串引起$O(n)$空间开销；
  - 使用逐位取余的方式，从右向左计算$dp[]$数组，将空间开销优化至$O(1)$；

```java
// Approach 2: 数值取余
class Solution {
    public int translateNum(int num) {
        if (num < 0)
            throw new RuntimeException("Invalid input!");
        int step2 = 1;
        int step1 = 1;
        int bit2 = num % 10;
        int bit1 = 0;
        int res = 1;
        while (num != 0) {
            num /= 10;
            bit1 = num % 10;
            int value = bit1 * 10 + bit2;
            res = (10 <= value && value <= 25) ? step2 + step1 : step1;
            step2 = step1;
            step1 = res;
            bit2 = bit1;
        }
        return res;
    }
}
```

# 2. Summary

- 参见 LeetCode 46 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.