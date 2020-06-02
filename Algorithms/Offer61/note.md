[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 61

## 1.1 复杂度分析

- 排序：
  
  - 时间复杂度：$O(nlogn)$；
  
  - 空间复杂度：$O(n)$；

## 1.2 排序

- 解题思路：
  - 数学建模：将`A`视为 1，将大王、小王视为 0；
  - 排序；
  - 统计 0 的数量，统计非零值之间的缺失值数量；
  - 若 0 的数量大于等于非零值之间的缺失值数量，则为“顺子”，否则不存在“顺子”；
- 注意：若存在非零重复值，则不存在“顺子”；

```java
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        int gap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            if (nums[i] == nums[i + 1])
                return false;
            gap += nums[i + 1] - nums[i] - 1;
        }
        return zero >= gap ? true : false;
    }
}
```

# 2. Summary

- 参见 剑指 Offer 61 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.