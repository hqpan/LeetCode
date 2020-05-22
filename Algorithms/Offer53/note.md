[TOC]



# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 34 & 剑指 Offer 53-I

## 1.1 复杂度分析

- 暴力求解：遍历；==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 二分法：
  - 时间复杂度：$O(logn)$；
  - 空间复杂度：$O(1)$；
- 相同的题：剑指 Offer 53-I，仅有返回值不同；

## 1.2 二分法

- 解题思路：考虑到数组为递增序列，因此可使用二分法；
  - 问题转化：求解目标值的左右边界索引；
    - `getFirst`方法：求解左边界索引；
    - `getLast`方法：求解右边界索引；
  - 以下分析`getFirst`方法的查找过程；
  - 若二分查找未命中目标值，则调整 lo、hi，迭代查找；
  - 若二分查找命中目标值：
    - `mid == 0`或`nums[mid-1] != target`：当前位置即为左边界；
    - 当前位置不为左边界，令$hi = mid - 1$，迭代查找；

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        int first = getFirst(nums, target);
        int last = getLast(nums, target);
        return new int[] {first, last};
    }

    public int getFirst(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else {
                if (mid == 0 || (nums[mid - 1] != target))
                    return mid;
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int getLast(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else {
                if (mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                lo = mid + 1;
            }
        }
        return -1;
    }
}
```

# 2. 剑指 Offer 53-II 

## 2.1 复杂度分析

- 暴力求解：遍历数组；==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 暴力求解：遍历数组，求所有元素之和，与数组索引之差，即为所求；==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 二分法：==无需复习==
  - 时间复杂度：$O(logn)$；
  - 空间复杂度：$O(1)$；

## 2.2 二分法

- 解题思路：考虑到数组为递增序列，因此可使用二分法；
  - 问题转化：求解数组中首个与索引不相等的值；
  - 若二分查找未命中目标值，则调整 lo、hi，迭代查找；
  - 若二分查找命中目标值：
    - `mid == 0`或`nums[mid-1] != mid - 1`：当前位置即为所求；
    - 否则令$hi = mid - 1$，迭代查找；

```java
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == mid) {
                lo = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == mid - 1)
                    return mid;
                hi = mid - 1;
            }
        }
        return nums.length;
    }
}
```

# 3. Summary

- 参见 LeetCode 34 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.