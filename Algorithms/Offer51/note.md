[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 51

## 1.1 复杂度分析

- 归并排序：
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(n)$；

## 1.2 归并排序

- 解题思路：
  - E.g. 在归并排序中，考虑将左右子数组$[1,3],[2,4]$合并；
  - 令左右指针 left、right 分别指向1、2；
  - 由于1<2，因此将1写入新数组中，并将 left 加1；
  - 由于3>2，因此将2写入新数组中，并将 right 加1；
  - 由于3<4，因此将3写入新数组中，并将 left 加1；
    - 虽然3<4，但3大于右子数组中4左侧的所有元素；
    - 因此$right-mid-1$即为此时逆序对的数量；
    - 每当移动 left 时，累加逆序对数量，结果即为所求；

```java
class Solution {
    private static int[] aux;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;        
        aux = new int[nums.length];
        return sort(nums, 0, nums.length - 1);
    }

    public static int sort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return 0;
        int mid = lo + (hi - lo) / 2;
        int countL = sort(nums, lo, mid);
        int countR = sort(nums, mid + 1, hi);
        return countL + countR + merge(nums, lo, mid, hi);
    }

    public static int merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = nums[i];
        int left = lo;
        int right = mid + 1;
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (left > mid)
                nums[i] = aux[right++];
            else if (right > hi) {
                nums[i] = aux[left++];
                count += right - mid - 1;
            }
            else if (aux[left] > aux[right])
                nums[i] = aux[right++];
            else {
                nums[i] = aux[left++];
                count += right - mid - 1;
            }                      
        }
        return count;
    }
}
```

# 2. Summary

- 参见剑指 Offer 51 解题思路；
- 复习归并排序；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.