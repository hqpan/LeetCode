[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 215 & 剑指 Offer 40

## 1.1 复杂度分析

- 排序：==无需复习==
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(logn)$；
- 基于堆的算法：
  - 时间复杂度：$O(nlogk)$；
  - 空间复杂度：$O(k)$；
  - k：题意中最大或最小的 k 个值；
- 基于 Partition 函数的算法：partition，n.[C] 分隔，隔离物，隔墙；
  - 时间复杂度：$O(n)$，证明过程参见《算法导论》；
  - 空间复杂度：$O(logn)$；
- 相似的问题：剑指 Offer 40；

## 1.2 基于堆的算法

- 解题思路：
  - 创建一个最大堆，存放 k 个最大元素；
  - 依次读入各个数值，将其存放至最大堆中；
  - 每当队中的元素数量大于 k 个时，弹出最大堆中的元素，即当前最大值；
  - 仅需将原始数据遍历一次，即可求得最小的 k 个数，或第 k 小的数；

```java
// Approach 1: Heap
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0)
            throw new RuntimeException("Invalid input!");
        PriorityQueue<Integer> heap = new PriorityQueue<>((val1, val2) -> val2 - val1);
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        int[] res = new int[k];
        for (int i = heap.size() - 1; i >= 0; i--)
            res[i] = heap.poll();
        return res;
    }
}
```

## 1.3 基于 Partition 的算法

- 解题思路：
  - Partition 函数：在快速排序算法中，Partition 函数在待排序的数组中，随机选取一个值，然后将小于该值的数放在其左侧，大于该值的数放在右侧；
  - 调用 Partition 函数，其返回值为排序后切分元素的索引；
    - 若该索引恰为 k，则求解结束；
    - 若该索引不为 k，则缩小范围，递归求解；

```java
// Approach 2: Partition
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0)
            throw new RuntimeException("Invalid input!");
        if (k == 0)
            return new int[] {};
        int lo = 0;
        int hi = arr.length - 1;
        int index = partition(arr, lo, hi);
        while (index != k - 1) {
            if (index < k - 1) {
                lo = index + 1;
                index = partition(arr, lo, hi);
            } else {
                hi = index - 1;
                index = partition(arr, lo, hi);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    public int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int base = arr[lo];
        while (true) {
            while (i < hi && arr[++i] < base)
                if (i == hi)
                    break;
            while (j > lo && arr[--j] > base)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
```

# 2. Summary

- Partition 函数：快速排序算法的一部分，可用于求解数组中第 n 大的数；==应掌握该函数==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(logn)$；
- 基于堆的算法：最小堆、最大堆；
  - 适用范围：从海量数据中找出最小或最大的 k 个数，考虑到内存大小有限，因此无法将所有数据全部读入内存；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.