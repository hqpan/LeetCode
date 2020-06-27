[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. 剑指 Offer 3
## 1.1 复杂度分析
- 暴力求解：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 排序：
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(1)$；
- 辅助数组：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 集合 or 哈希表：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 原地标记数组 or 原地交换元素：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 1.2 集合
- 解题思路：无须赘述；

```java
// Approach 1: HashSet
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            if (!set.add(nums[i]))
                return nums[i];
        return -1;
    }
}
```

## 1.3 原地标记数组

- 解题思路：
  - 由题意可知，数组中元素取值范围$[0,n-1]$；
  - 遍历数组一次：
    - 若当前值对应的索引位置上的元素值大于 0，则将其减 n；
    - 若当前值对应的索引位置上的元素值小于 0，该索引值即为所求；
- Q：在选取标记方式时，为什么不将对应值取反，而是减去 n？
  - 因为本题数组中元素取值范围$[0,n-1]$；
  - 若取反，则无法表示 0 已被标记过；

```java
// Approach 2: negative number
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index < 0)
                index += nums.length;
            if (nums[index] < 0)
                return index;
            nums[index] = nums[index] - nums.length;
        }
        return -1;
    }
}
```

# 2. Summary

## 2.1 Java 语法

- HashSet：`java.util.HashSet`，集合中的元素无序、不重复；
  - `public boolean add(E e)`；
  - `public boolean remove(Object o)`；
  - `public boolean contains(Object o)`；
  - `public boolean isEmpty()`；
  - `public int size()`；

## 2.2 算法设计

- 标记方式选取：为什么不将对应值取反，而是减去 n？
  - 因为本题数组中元素取值范围$[0,n-1]$；
  - 若取反，则无法表示 0 已被标记过；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.