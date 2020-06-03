[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 121 & 剑指 Offer 63

## 1.1 复杂度分析

- 打擂算法：
  
  - 时间复杂度：$O(n)$；
  
  - 空间复杂度：$O(1)$；
- 相同的题：剑指 Offer 63；

## 1.2 打擂算法

- 解题思路：数组中两个元素，后者和前者差值的最大值；
  - 第一个打擂算法：保存当前日期以前，股票的最低价格，当前价格减去历史最低价格，即为当前最大利润；
  - 第二个打擂算法：保存每日最大利润中的最大值，结果即为所求；

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (min > price)
                min = price;
            else if (price - min > res)
                res = price - min;
        }
        return res;
    }
}
```

# 2. LeetCode 309

- ==unsolved==

# 3. Summary

- 参见 LeetCode 121 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.