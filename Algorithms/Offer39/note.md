[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 169 & 剑指 Offer 39

## 1.1 复杂度分析

- 暴力求解：即二重循环；==无需复习==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 排序：==无需复习==
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(1)$；
- 哈希表：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 基于 Partition 的算法：partition，n.[C] 分隔，隔离物，隔墙；
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(logn)$；
- Boyer-Moore 投票算法：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 相同的问题：剑指 Offer 39；

## 1.2 基于 Partition 的算法
- 解题思路：
  - Partition 函数：在快速排序算法中，Partition 函数在待排序的数组中，随机选取一个值，然后将小于该值的数放在其左侧，大于该值的数放在右侧；
  - 考虑到本题中，某数出现次数超过数组长度的一般，则排序后的数组中第$\frac{n}{2}$个数（数组中值）必为所求，问题转换为求解数组中第$\frac{n}{2}$大的数；
  - 若 Partition 函数处理后：
    - 被选择的切分数值下标恰为$\frac{n}{2}$，则该值即为中值；
    - 被选择的切分数值下标小于$\frac{n}{2}$，则该值位于中值左侧；
    - 被选择的切分数值下标大于$\frac{n}{2}$，则该值位于中值右侧；
  - 迭代调用 Partition 函数，即可求得数组中值；

```java
// Approach 1: 基于 Partition 的算法
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid array!");
        int lo = 0;
        int mid = nums.length >> 1; // take notes
        int hi = nums.length - 1;
        int index = partition(nums, lo, hi);
        while (index != mid) {
            if (index > mid) {
                hi = index - 1;
                index = partition(nums, lo, hi);
            } else {
                lo = index + 1;
                index = partition(nums, lo, hi);
            }
        }
        return nums[mid];
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1; // ???
        int base = nums[lo];
        while (true) {
            while (i < hi && nums[++i] < base)
                if (i == hi)
                    break;
            while (j > lo && nums[--j] > base)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    public void exch(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
```

## 1.3 Boyer-Moore 投票算法

- 解题思路：
  - 若被选择的数不是众数，则众数和其它非众数将反对候选值，候选值最终不会被选中，在计分为0时，更换被选择的数：
  - 若被选择的数是众数，则显然被选择的数将是最终结果；

```java
// Approach 2: Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid array!");
        int res = nums[0];
        int votes = 0;
        for (int num : nums) {
            if (votes == 0)
                res = num;
            votes += res == num ? 1 : -1;
        }
        return res;
    }
}
```

# 2. Summary

- Partition 函数：可用于求解数组中第 n 大的数；==应掌握该函数==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(logn)$；
- Boyer-Moore 投票算法：
  - 若被选择的数不是众数，则众数和其它非众数将反对候选值，候选值最终不会被选中，在计分为0时，更换被选择的数：
  - 若被选择的数是众数，则显然被选择的数将是最终结果；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.