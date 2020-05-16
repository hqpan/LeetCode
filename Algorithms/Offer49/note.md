[TOC]



# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 263

## 1.1 复杂度分析

- 按“丑数”的定义判断：==无需复习==
  - 时间复杂度：取决于输入，$O(1)$或$O(n)$；
  - 空间复杂度：$O(1)$；

## 1.2 按“丑数”的定义判断

- 解题思路：
  - 将输入值不断除以2、3、5，直至无法整除；
  - 若计算结果为1，则该输入值满足“丑数”定义；
- 注意：检测输入值是否为正整数，避免无法退出循环，超出时间限制；

```java
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        while (num % 2 == 0)
        {
            num /= 2;
        }
        while (num % 3 == 0)
        {
            num /= 3;
        }
        while (num % 5 == 0)
        {
            num /= 5;
        }
        return num == 1;
    }
}
```

# 2. LeetCode 264 & 剑指 Offer 49

## 2.1 复杂度分析

- 暴力求解：==无需复习==
  - 从1开始遍历所有整数，逐个检查是否为“丑数”，直至找出第n个丑数；
  - 缺陷：需要检查大量不满足“丑数”条件的数值；
- 动态规划：暴力搜索需要检查大量不满足“丑数”要求的数值，因此可尝试生成“丑数”，以减少时间开销；
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 49；

## 2.2 动态规划

|  Num2  |  Num3  |  Num5  | uglyNum |
| :----: | :----: | :----: | :-----: |
|        |        |        |    1    |
|   2    |   3    |   5    |    2    |
| **4**  |        |        |    3    |
|        | **6**  |        |    4    |
| **6**  |        |        |    5    |
|        |        | **10** |    6    |
| **8**  | **9**  |        |    8    |
| **10** |        |        |    9    |
|        | **12** |        |   10    |
|  ...   |  ...   |  ...   |   ...   |

- 解题思路：
  - 递归分析：
    - 从数值1开始，每个数值均可与因数2、3、5相乘，生成新的“丑数”；
    - 生成“丑数”的过程是一个组合问题，而非排列问题，E.g. “丑数”$10=2\times 5=5\times 2$；
    - 为避免重复计算子结构（新生成的“丑数”），在迭代求解过程种，需创建一个长度为n的数组，存放 n个“丑数”；
  - 迭代求解：
    - 不妨设已求出前 i-1 个丑数，欲求第 i 个丑数；
      - 将因数2、3、5分别与前 i-1 个丑数相乘，即可得到第 i 个丑数的候选集；
      - 第 i 个丑数应大于第 i-1 个丑数，且为所有满足该条件的候选集中的最小值；
    - 优化：无需检测小于第 i-1 个丑数的值；
      - 定义3个指针：index2、index3、index5，分别指向将与因数2、3、5相乘的较小丑数；
      - 新丑数应为三者中的最小值；
      - 令对应的指针变量加一；

```java
class Solution {
    public static int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int nextNum2 = ans[index2] * 2;
        int nextNum3 = ans[index2] * 3;
        int nextNum5 = ans[index2] * 5;

        for(int i = 1; i < n; i++)
        {
            ans[i] = Math.min(nextNum2, Math.min(nextNum3, nextNum5));

            if(ans[i] == nextNum2)
                nextNum2 = ans[++index2] * 2;
            if(ans[i] == nextNum3)
                nextNum3 = ans[++index3] * 3;
            if(ans[i] == nextNum5)
                nextNum5 = ans[++index5] * 5;
        }
        return ans[n-1];
    }
}
```

# 3. Summary

- 参见 LeetCode 264 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.