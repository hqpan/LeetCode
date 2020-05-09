[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 233 & 剑指 Offer 43

## 1.1 复杂度分析

- 相同的问题：剑指 Offer 43；
- 数学分析：
  - 时间复杂度：$O(logn)$；
  - 空间复杂度：$O(1)$；

## 1.2 数学分析

- 解题思路：
  - 排列问题：E.g. n = 1234，计算 0000-1234 范围内1出现的次数；
  - 以十位为例，分析如下：
    - 若十位上的数值为0，E.g. n = 1204；
      - 千位、百位：000-119；
      - 十位：1；
      - 则剩余3位上可能的排列有$=12\times10=120$种；
    - 若十位上的数值为1，E.g. n = 1214；
      - 千位、百位、个位：000-124；
      - 十位：1；
      - 则剩余3位上可能的排列有$=12\times10+4+1=125$种；
    - 若十位上的数值大于1，E.g. n = 1224；
      - 千位、百位、个位：000-129；
      - 十位：1；
      - 则剩余3位上可能的排列有$=(12+1)\times10=130$种；
  - 对每一位计算时，需要维护的变量：
    - low：当前位的低位值；
    - curr：当前位的值；
    - high：当前位的高位值；
    - digit：当前位的权重，E.g. 十位的 digit = 10；
  - 循环终止条件：
    - 当前位值为0，且高位值为0；
    - 表明没有需要计算的位；

```java
class Solution {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;         
        int low = 0;
        int curr = n % 10;
        int high = n / 10;
        int digit = 1;
        int res = 0;
        while (high != 0 || curr != 0) {
            switch (curr) {
                case 0: res += high * digit; break;
                case 1: res += high * digit + low + 1; break;
                default: res += (high + 1) *digit;
            }
            low += curr * digit;
            curr = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
```

# 2. Summary

- 参见 LeetCode 233 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.