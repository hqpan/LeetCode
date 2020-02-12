[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 343
## 1.1 复杂度分析
- 题意解析：
  - 考察内容：动态规划、贪心算法；
  - 与整数拆分问题类似的问题，还有剪绳子问题（剑指 Offer 14-I、剑指 Offer 14-II）；
- 动态规划：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(n)​$；
- 贪心算法：
  - 时间复杂度：$O(1)​$；
  - 空间复杂度：$O(1)​$；



## 1.2 动态规划
- 动态规划的适用条件：
  - 最优化原理（最优子结构性质） ：一个最优化策略的子策略总是最优的；
  - 无后效性：对于某个给定的阶段状态，其以前各阶段的状态无法直接影响未来的决策，而只能通过当前的这个状态影响未来决策；
  - 子问题的重叠性：动态规划将指数级时间复杂度的搜索算法改进成具有多项式时间复杂度的算法，关键在于以空间换时间，存储计算过程中的中间状态，避免冗余计算，因此动态规划算法的空间复杂度大于其它算法；
- 解题思路：
  - 由题意可知，将给定的正整数 n 至少拆分为2个正整数，不妨先将其拆分为2个正整数，然后进一步拆分得到的正整数；
  - 将 n 的最大乘积记为 $f(n)$，则$f(n)=max(f(i)\times f(n-i))$；
  - 分析问题时，自顶向下递归拆分；
  - 求解问题时，为避免对子问题进行重复计算，创建一个长度为 n+1 的数组存放中间状态，从而避免冗余计算；

```java
// Approach 1: Dynamic programming
class Solution {
    public int integerBreak(int n) {
        if (n <= 1)
            throw new RuntimeException("Input error: n <= 1.");
        if (n <= 3)
            return n - 1;
        int[] product = new int[n + 1];
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++)
                if (product[j] * product[i - j] > max)
                    max = product[j] * product[i - j];
            product[i] = max;
        }
        return product[n];
    }
}
```



## 1.3 贪心算法

- 解题思路：
  - 判断是否存在最优的“因数”使得乘积最大化；
    - $2=1+1,\space 1\times 1=2​$；
    - $3=1+2,\space 1\times 2=3​$；
    - $4=2+2,\space 2\times 2=4​$；
    - $5=2+3,\space 2\times 3=6$；
    - $5=3+3,\space 3\times 3=9$；
  - 显然有最优的“因数”3使得乘积最大化；
  - 因此尽可能将整数拆分为若干个3；
    - 若剩余部分为1，易知$1\times 3<2\times 2​$，应将一个$1\times 3​$转换为$2\times 2​$；
    - 若剩余部分为2，则$3^x\times 2$即为所求；

```java
// Approach 2: Greedy algorithm
class Solution {
    public int integerBreak(int n) {
        if (n <= 1)
            throw new RuntimeException("Input error: n <= 1.");
        if (n <= 3)
            return n - 1;
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0)
            return (int) Math.pow(3, quotient);
        if (remainder == 1)
            return (int) Math.pow(3, quotient - 1) * 4;
        return (int) Math.pow(3, quotient) * 2;
    }
}
```



# 2. 剑指 Offer 14-I

## 2.1 复杂度分析

- 题意解析：与 LeetCode 343 完全一致；
- 注意：由题意可知，$n\in [2,58]$，使用 int 类型足以存储所求值；



# 3. 剑指 Offer 14-II

## 3.1 复杂度分析

- 题意解析：
  - 由题意可知，$n\in [2,1000]$，$3^{332}\times 4>2^{63}-1$；
  - 使用 int、long 类型无法存储所求值；
  - 因此需使用 Java 中的大整数类、大浮点数类；
  - 求解思路与 LeetCode 343 基本一致；



## 3.2 动态规划

```java
// Approach 1: Dynamic programming
import java.math.BigDecimal;
class Solution {
    public int cuttingRope(int n) {
        if (n < 1)
            throw new RuntimeException("Input error: n < 1.");
        if (n <= 3)
            return n - 1;
        BigDecimal[] product = new BigDecimal[n + 1];
        product[1] = new BigDecimal(1);
        product[2] = new BigDecimal(2);
        product[3] = new BigDecimal(3);
        for (int i = 4; i <= n; i++) {
            BigDecimal max = new BigDecimal(0);
            for (int j = 1; j <= i / 2; j++)
                if (product[j].multiply(product[i - j]).compareTo(max) > 0)
                    max = product[j].multiply(product[i - j]);
            product[i] = max;
        }
        BigDecimal mod = new BigDecimal(1_000_000_007);
        return product[n].remainder(mod).intValue();
    }
}
```





## 3.3 贪心算法

```java
// Approach 2: Greedy algorithm
import java.math.BigDecimal;
class Solution {
    public int cuttingRope(int n) {
        if (n < 1)
            throw new RuntimeException("Input error: n < 1.");
        if (n <= 3)
            return n - 1;
        int quotient = n / 3;
        int remainder = n % 3;
        BigDecimal two = new BigDecimal(2);
        BigDecimal three = new BigDecimal(3);
        BigDecimal four = new BigDecimal(4);
        BigDecimal mod = new BigDecimal(1_000_000_007);
        if (remainder == 0)
            return three.pow(quotient).remainder(mod).intValue();
        if (remainder == 1)
            return three.pow(quotient - 1).multiply(four).remainder(mod).intValue();
        return three.pow(quotient).multiply(two).remainder(mod).intValue();
    }
}
```



# 4. Summary

## 4.1 动态规划

- 动态规划的适用条件：
  - 最优化原理（最优子结构性质） ：一个最优化策略的子策略总是最优的；
  - 无后效性：对于某个给定的阶段状态，其以前各阶段的状态无法直接影响未来的决策，而只能通过当前的这个状态影响未来决策；
  - 子问题的重叠性：动态规划将指数级时间复杂度的搜索算法改进成具有多项式时间复杂度的算法，关键在于以空间换时间，存储计算过程中的中间状态，避免冗余计算，因此动态规划算法的空间复杂度大于其它算法；



## 4.2 Java 语法

- `java.math.BigDecimal`：

  - 构造函数：
    - `public BigDecimal(int val)`；
    - `public BigDecimal(long val)`；
    - `public BigDecimal(double val)`；
    - `public BigDecimal(String val)`；
  - `public BigDecimal add(BigDecimal augend)`；
  - `public BigDecimal subtract(BigDecimal subtrahend)`；
  - `public BigDecimal multiply(BigDecimal multiplicand)`；
  - `public BigDecimal divide(BigDecimal divisor)`；
  - `public int compareTo(BigDecimal val)`；
  - `public BigDecimal pow(int n)`：乘方；
  - `public BigDecimal remainder(BigDecimal divisor)`：取余；
  - `public int intValue()`：将大浮点数转换为 int 类型；
  - `public long longValue()`：将大浮点数转换为 long 类型；
  - `public double doubleValue()`：将大浮点数转换为 double 类型；

- `java.math.BigInteger`：参见 Java docs；

  

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.