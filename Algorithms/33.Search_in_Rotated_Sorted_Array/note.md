[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. Overview

- LeetCode 153，寻找旋转排序数组中的最小值，数组中不含有重复数值；
- LeetCode 154，寻找旋转排序数组中的最小值，且数组中可能含有重复数值；
- LeetCode 33，搜索旋转排序数组中是否含有特定值，数组中不含有重复数值；
- LeetCode 81，搜索旋转排序数组中是否含有特定值，且数组中可能含有重复数值；



# 2. LeetCode 153

## 1.1 复杂度分析

- 暴力搜索：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)​$；
- 二分法：
  - 时间复杂度：$O(log(n)$；
  - 空间复杂度：$O(1)​$；



## 1.2 二分法
- 解题思路：
  - 查找有序数组和部分有序数组中的元素，考虑使用二分法；
  - 由题中旋转数组定义可知，数组可划分为两部分，第一个子数组中的任意数值均大于第二个子数组中的任意数值；
    - 若$nums[mid]>nums[hi]​$，则表明中点位于第一个子数组中；
    - 若$nums[mid]<nums[lo]$，则表明中点位于第二个子数组中；
  - 重复上述步骤，直至$lo==hi$，即可求得最小值在数组中的索引；
- 难点：
  - Q1：为什么不将$mid=lo+\frac{(hi-lo)}{2}$化简为$mid=\frac{(hi+lo)}{2}$？
  - A1：$hi+lo$可能会大于`Integer.MAX_VALUE`，造成数据溢出；
  - Q2：若旋转数组中，仅有0个元素被旋转，即数组中所有元素单调递增，应当如何检测？
  - A2：对本题中的如下程序，无需额外处理；

```java
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (hi < 0)
            throw new RuntimeException("This is an empty array.");
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[hi];
    }
}
```



# 2. LeetCode 154

## 2.1 复杂度分析
- LeetCode 154 和 153 的解题思路基本一致；
- 暴力搜索：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 二分法：
  - 时间复杂度：$O(log(n)$；
  - 空间复杂度：$O(1)​$；



## 2.2 二分法

- 难点：
  - 若数组中存在重复值，则使用二分法的时可能出现$nums[mid]==nums[hi]$；
  - 此时无法判断数组左右两部分之间的有序性关系，此时应使用顺序查找；
  - 具体操作为，当$nums[mid]==nums[hi]​$时，使`hi--`，将指针移动一位，逐位检测数组是否满足要求，即为顺序查找；

```java
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (hi < 0)
            throw new RuntimeException("This is an empty array.");
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else if (nums[mid] < nums[hi])
                hi = mid;
            else
                hi--;
        }
        return nums[hi];
    }
}
```



# 3. LeetCode 33

## 3.1 复杂度分析

- 二分法：
  - 时间复杂度：$O(log(n)$；
  - 空间复杂度：$O(1)$；



## 3.2 二分法

- 解题思路：
  - 旋转数组是一个部分有序的数组，仍可以借助有序性不断缩小查找范围；
  - 由于旋转点的位置不缺定，因此需要通过$nums[lo]、nums[mid]、nums[hi]$的相对大小关系，判断左右子数组的有序性；
  - 若$nums[mid]<nums[hi]$，则表明右子数组有序；
    - 若待查找值位于此区间之内，则继续查找右子数组；
    - 若待查找值不位于此区间之内，则继续查找左子数组；
  - 若$nums[mid]>nums[hi]$，则表明左子数组有序；
    - 若待查找值位于此区间之内，则继续查找右子数组；
    - 若待查找值不位于此区间之内，则继续查找左子数组；
  - 重复上述步骤，直至找出目标值或循环终止；

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < nums[hi])
                if (nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            else
                if (nums[0] <= target && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
        }
        return -1;
    }
}
```



# 4. LeetCode 81

# 

## 4.1 复杂度分析

- LeetCode 81 和 33 的解题思路基本一致；
- 二分法：
  - 时间复杂度：$O(log(n)$；
  - 空间复杂度：$O(1)​$；



## 4.2 二分法

- 难点：与 LeetCode 154 相同；
  - 若数组中存在重复值，则使用二分法的时可能出现$nums[mid]==nums[hi]$；
  - 此时无法判断数组左右两部分之间的有序性关系，此时应使用顺序查找；
  - 具体操作为，当$nums[mid]==nums[hi]$时，使`hi--`，将指针移动一位，逐位检测数组是否满足要求，即为顺序查找；

```java
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid])
                return true;
            if (nums[mid] < nums[hi])
                if (nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            else if (nums[mid] > nums[hi])
                if (nums[lo] <= target && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            else
                hi--;
        }
        return false;
    }
}
```





# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.