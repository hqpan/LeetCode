[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 53 & 剑指 Offer 42

## 1.1 复杂度分析

- 相同的问题：剑指 Offer 42；
- 相似的问题：LeetCode 152；
- 二重循环：暴力搜索；==无需复习==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 动态规划：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 1.2 动态规划

- 解题思路：
  - 状态定义：
    - 创建一个数组 dp，用于存放各个状态值；
    - dp[i] 表示以元素 nums[i] 结尾的最大子序和；
  - 状态转移方程：
    - 若$dp[i-1]>0$，表明前序元素贡献为正值，则$dp[i]=dp[i-1]+nums[i]$；
    - 若$dp[i-1]<0$，表明前序元素贡献为负值，则$dp[i]=nums[i]$；
    - 注意：初始状态$dp[0]=nums[0]$；
  - 优化空间复杂度：
    - 考虑到 dp[i] 仅与 dp[i-1] 有关，而与 dp[0]、……、dp[i-2] 无关；
    - 滚动数组：使用打擂台算法，用1个变量保存 dp[i-1] 值即可，无需创建 dp 数组保存所有的状态值；

```java
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {  
            currSum = currSum <= 0 ? num : num + currSum;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
```

# 2. LeetCode 152

## 2.1 复杂度分析

- 二重循环：暴力搜索；==无需复习==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 动态规划：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 2.2 动态规划

- 解题思路：
  - LeetCode 53：加法；
    - 若前序元素贡献为正值，则累加；
    - 若前序元素贡献为负值，则不累加；
  - LeetCode 152：乘法；
    - 首先不考虑累乘2个负数，得到更大正数的情况，当前值有2种取值可能；
      - 恰为当前值；
      - 前序元素与当前值的乘积；
    - 其次考虑累乘2个负数，得到更大正数的情况；
      - 创建2个变量 max 和 min；
      - $max = Math.max(num, num * max)$； 
      - $min = Math.min(num, num * min)$；
      - 若当前值为负数，则将 max 和 min 互换后执行后续计算；

```java
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num, num * max);
            min = Math.min(num, num * min);
            res = Math.max(max, res);
        }
        return res;
    }
}
```

# 3. Summary

- 参见 LeetCode 53 & 152；
- DP 问题：用递归的方式思考，用迭代的方式求解；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.