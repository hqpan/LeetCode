[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 70 & 剑指 Offer 10-II
## 1.1 复杂度分析
- 题意解析：
  - LeetCode 70 爬楼梯问题，亦称青蛙跳台阶问题；
    - 数学模型为 Fibonacci 数列；
    - 设 n 级台阶的跳法有$f(n)$种，则由跳台阶规则可知，$f(n)=f(n-1)+f(n-2)$；
  - 类似的实际问题还有矩形覆盖问题，给定由$2\times 8$个小方格组成的大矩形，和一个由$2\times $1个小方格组成的小矩形，若使用小矩形覆盖大矩形，试求共有多少种方法？
    - 状态定义：不妨将$2\times 8$的覆盖方法数记为$f(8)$；
    - 状态转移方程：
      - 若将1个小矩形竖放于大矩形中，则剩余$2\times 7$，即剩余区域的覆盖方法数记为$f(7)$；
      - 若将1个小矩形横放于大矩形的左上角，由几何关系知，左下角必须再次横放一个小矩形，剩余$2\times 6$，即剩余区域的覆盖方法数记为$f(6)$；
      - 由此可知$f(8)=f(7)+f(6)$;
- 递归：
  - 时间复杂度：$O(2^n)$，因为每种状态可由 2 种前驱状态转换得到；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 举一反三：
  - 相同的题：剑指 Offer 10-II；
  - 相似的题：
    - LeetCode 509，剑指 Offer 10-I；
    - LeetCode 1137；

## 1.2 迭代
- Q1：两种方法的区别？
  - Approach 1：创建一个长度为n的数组，存放$f(1),f(2),...,f(n)$；
  - Approach 2：创建两个变量，用于保存 Fibonacci 数列中的前两项；
- A1：Approach 2 借助滚动数组，将空间复杂度从$O(n)$减小至$O(1)$；

```java
class Solution {
    public int numWays(int n) {
        int lo = 1;
        int hi = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (lo + hi) % 10_0000_0007;
            lo = hi;
            hi = sum;
        }
        return hi;
    }
}
```

# 2. LeetCode 509 & 剑指 Offer 10-I

## 2.1 复杂度分析
- LeetCode 509 和 70 、1137 的解题思路基本一致；

## 2.2 迭代

- 难点：Java 强制要求处理`Exception`（即含有`catch`语句），但对`RuntimeException`无强制要求；

```java
class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int lo = 0;
        int hi = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (lo + hi) % 10_0000_0007;
            lo = hi;
            hi = sum;
        }
        return hi;
    }
}
```

# 3. LeetCode 1137

## 2.1 复杂度分析

- LeetCode 1137 和 70 、509 的解题思路基本一致；

## 2.2 迭代

```java
class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        int value1 = 0;
        int value2 = 1;
        int value3 = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = value1 + value2 + value3;
            value1 = value2;
            value2 = value3;
            value3 = sum;
        }
        return value3;
    }
}
```

# 4. Summary

## 4.1 Java 语法

- Java 强制要求处理`Exception`（即含有`catch`语句），但对`RuntimeException`无强制要求；

## 4.2 算法设计

- 本文 1.1 中的矩形覆盖问题的状态定义、状态转移方程；
- 递归的缺点：
  - 递归中重复计算子结构，造成不必要的时间开销，==应以递归思想分析问题，使用迭代方式自底向上求解==；
  - 每次函数调用时，都需要在内存栈中分配空间保存参数、返回地址和临时变量；
  - 由于每个进程的栈容量有限，若递归层数过多，则会造成栈溢出；
- 为防止数值溢出，对`sum`取模；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.