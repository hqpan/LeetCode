[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 57-I

## 1.1 复杂度分析

- 暴力求解：==无需复习==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 双指针：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 1.2 双指针

- 解题思路：
  - 双指针分别指向数组的首部和尾部；
  - 若两数之和小于目标值，则令尾指针后退1步；
  - 若两数之和大于目标值，则令头指针前进1步；
  - $0\oplus a=a$；
    - 任何值与0进行异或运算，均不改变该值；
  - 异或运算满足交换律与结合律：$a\oplus b\oplus a=(a\oplus a)\oplus b=0\oplus b =b$；

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1)
            throw new RuntimeException("Invalid input!");
        int before = 0;
        int behind = nums.length - 1;
        while (before < behind) {
            int sum = nums[before] + nums[behind];
            if (sum == target)
                return new int[] {nums[before], nums[behind]};
            if (sum < target)
                before++;
            else
                behind--;
        }
        return null;
    }
}
```

# 2. Offer 57-II

## 2.1 复杂度分析

- 暴力求解：==无需复习==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 双指针：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 2.2 双指针

- 解题思路：在前一个序列和的基础上求解下一个序列和，减少计算运算；
  - 定义双指针，均指向数组首部；
  - 定义一个变量`sum`记录两指针之间的数值之和；
  - 若当前元素之和小于目标值，则令`sum`累加当前尾指针指向的元素，并右移尾指针；
  - 若当前元素之和大于目标值，则令`sum`减去当前头指针指向的元素，并右移头指针；
  - 若当前元素之和等于目标值，则记录当前结果，令`sum`减去当前头指针指向的元素，并右移头指针；

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target < 3)
            throw new RuntimeException("Invalid input!");
        int before = 1;
        int behind = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (before <= target / 2) {
            if (sum < target) {
                sum += behind;
                behind++;
            } else if (sum > target) {
                sum -= before;
                before++;
            } else {
                int[] row = new int[behind - before];
                for (int i = 0; i < behind - before; i++)
                    row[i] = i + before;
                res.add(row);
                sum -= before;
                before++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```

# 3. Summary

- 参见 剑指 Offer 57-I & 57-II 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.