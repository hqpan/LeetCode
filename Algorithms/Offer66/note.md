[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 66

## 1.1 复杂度分析

- 被乘数分区：
  
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 1.2 被乘数分区

- 解题思路：
  - 由题意可知，不得使用除法运算；
  - 分析乘积，可得如下被乘数表格；
  - 2 次累乘：
    - 将下三角矩阵中的项累乘至`res[]`中；
    - 将上三角矩阵中的项累乘至`res[]`中；

|            |       |       |       |           |           |           |
| :--------: | :---: | :---: | :---: | :-------: | :-------: | :-------: |
|   res[0]   | ==1== | $A_1$ | $A_2$ |    ...    | $A_{n-2}$ | $A_{n-1}$ |
|   res[1]   | $A_0$ | ==1== | $A_2$ |    ...    | $A_{n-2}$ | $A_{n-1}$ |
|   res[2]   | $A_0$ | $A_1$ | ==1== |    ...    | $A_{n-2}$ | $A_{n-1}$ |
|    ...     | $A_0$ | $A_1$ |  ...  |   ==1==   | $A_{n-2}$ | $A_{n-1}$ |
| res[n - 2] | $A_0$ | $A_1$ |  ...  | $A_{n-3}$ |   ==1==   | $A_{n-1}$ |
| res[n - 1] | $A_0$ | $A_1$ |  ...  | $A_{n-3}$ | $A_{n-2}$ |   ==1==   |



```java
class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2)
            return new int[0];
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++)
            res[i] = 1;
        int product = 1;
        for (int i = 0; i < a.length - 1; i++) {
            product *= a[i];
            res[i + 1] *= product;
        }
        product = 1;
        for (int i = a.length - 1; i > 0; i--) {
            product *= a[i];
            res[i - 1] *= product;
        }
        return res;
    }
}
```

# 2. Summary

- 参见剑指 Offer 66 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.