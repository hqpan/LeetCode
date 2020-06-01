[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 60

## 1.1 复杂度分析

- 递归：
  
  - 时间复杂度：$O(n)$；
  
  - 空间复杂度：$O(n)$；
- 迭代：DP；

  - 时间复杂度：$O(n)$；

  - 空间复杂度：$O(n)$；

## 1.2 递归

- 解题思路：
  - 若有 n 个骰子，则点数之和的取值范围为$[n,6n]$，创建一个数组记录对应点数和出现的次数；
  - 第 1 个骰子的点数取值有 6 种情况，分别为 1、2、3、4、5、6，对 6 种情况进行递归调用；
  - 若递归至第 n 个骰子，则递归结束，将对应的点数和次数加 1；
  - 将数组中保存的所有点数和除以$6^n$，即为所求；

```java
// Approach 1: Recursion
class Solution {
    private int n;
    private int maxValue;
    private double[] res;
    public double[] twoSum(int n) {
        if (n < 1)
            return new double[0];
        this.n = n;
        this.maxValue = 6;
        int maxSum = maxValue * n;
        res = new double[maxSum - n + 1];
        for (int i = 1; i <= maxValue; i++)
            compute(n, i);
        double total = Math.pow(maxValue, n);
        for (int i = 0; i < res.length; i++)
            res[i] /= total;
        return res;
    }
    public void compute(int count, int sum) {
        if (count == 1) {
            res[sum - n]++;
            return;
        }
        for (int i = 1; i <= maxValue; i++)
            compute(count - 1, sum + i);
    }
}
```

## 1.3 迭代

- 解题思路：
  - 考虑到递归求解过程中，需要计算重复子结构，E.g. $sum3=sum1+sum2$，$sum4=sum1+sum2+sum3$；
  - 创建一个数组`res`，保存前 i 个骰子产生的点数和；
  - 状态定义：`res`长度为$6n+1$，存放点数和为$[0,6n]$出现的次数；
  - 初始状态：`res`中索引为$[1,6]$的元素值置为1，即第 1 个骰子的点数统计结果；
  - 状态转移方程：
    - 在第 i 个骰子的统计过程中，不妨将当前点数 j 出现的次数记为$f(j)$；
    - $f(j)=f(j-1)+f(j-2)+f(j-3)+f(j-4)+f(j-5)+f(j-6)$；
    - 从后向前遍历数组，并计算对应的次数和，若从前向后计算将导致第 i-1 个骰子的值被覆盖；
- 难点：`j-k>=i-1`；
  - 注意在计算次数和时，不应累加 i-1 之前的值，因为第  i-1 个骰子的次数和必大于 i-1；
  - 第 i 个骰子的次数和是在第 i-1 个骰子的次数和基础上进行累加；
  - 故有`j-k>=i-1`；

```java
// Approach 2: Iteration
class Solution {
    public double[] twoSum(int n) {
        if (n < 1)
            return new double[0];
        int maxValue = 6;
        double[] res = new double[n * maxValue + 1];
        for (int i = 1; i <= maxValue; i++)
            res[i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i * maxValue; j >= i; j--) {
                res[j] = 0;
                for (int k = 1; k <= maxValue; k++) {
                    if (j - k >= i - 1)
                        res[j] += res[j - k];
                }
            }
        }
        double total = Math.pow(maxValue, n);
        for (int i = 1; i < res.length; i++)
            res[i] /= total;
        return Arrays.copyOfRange(res, n, n * maxValue + 1); 
    }
}
```

# 2. Summary

- 参见 剑指 Offer 60 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.