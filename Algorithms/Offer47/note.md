[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 47

## 1.1 复杂度分析

- 动态规划：==无需复习==
  - 时间复杂度：$O(mn)$，m、n 分别表示二维数组的行数和列数；
  - 空间复杂度：$O(n)$，dp 数组占用的空间；

## 1.2 动态规划

- 解题思路：DP 问题；
  - 递归分析：对于二维矩阵中的每个值均有2种移动方式：向下、向右；
  - 迭代求解：避免重复计算子结构；
    - 创建与原始数组等大的二维数组$dp[row][column]$；
    - 使用二重循环，逐行、逐列计算到达当前位置的最大礼物价值；
  - 空间复杂度优化：
    - Approach 1：
      - $dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])$，即$dp[i][j]$仅与$dp[i-1][j]$、$dp[i][j-1]$有关；
      - 在 DP 问题中，常使用滚动数组取代一维数组，此处考虑使用一维数组取代二维数组；
      - 创建一维数组$dp[column]$，则有$dp[0]$至$dp[j-1]$表示第$i$行中对应列的最大礼物价值，$dp[j]$至$dp[column-1]$表示第$i-1$行中对应列的最大礼物价值；
      - 即可将空间复杂度从$O(mn)$优化为$O(n)$；
    - Approach 2：
      - 原地修改原始数组，用于存放当前位置的礼物最大价值；
      - 优点：空间复杂度$O(1)$；
      - 缺点：需要修改原始数组；

```java
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] dp = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0)
                    dp[j] = grid[i][j];
                else if (i == 0)
                    dp[j] = dp[j - 1] + grid[i][j];
                else if (j == 0)
                    dp[j] = dp[j] + grid[i][j];
                else
                    dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[column - 1];
    }
}
```

# 2. Summary

- 参见剑指 Offer 47 解题思路中对空间复杂度的优化；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.