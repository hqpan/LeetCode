[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 70
## 1.1 复杂度分析
- 题意解析：
  - LeetCode 70 爬楼梯问题，亦称青蛙跳台阶问题，该问题的数学模型为 Fibonacci 数列；
    - 设 n 级台阶的跳法有$f(n)$种，则由跳台阶规则可知，$f(n)=f(n-1)+f(n-2)$；
  - 类似的实际问题还有矩形覆盖问题，给定由$2\times 8​$个小方格组成的大矩形，和一个由$2\times ​$1个小方格组成的小矩形，若使用小矩形覆盖大矩形，试求共有多少种方法？
    - 不妨将$2\times 8$的覆盖方法数记为$f(8)$，若将1个小矩形竖放于大矩形中，则剩余$2\times 7$，即剩余区域的覆盖方法数记为$f(7)$；
    - 若将1个小矩形横放于大矩形的左上角，由几何关系知，左下角必须再次横放一个小矩形，剩余$2\times 6$，即剩余区域的覆盖方法数记为$f(6)$；
    - 综上所述，可知$f(8)=f(7)+f(6)$;
- 递归：
  - 时间复杂度：$O(2^n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - ·时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 递归和迭代的比较：
  - 递归：
    - 优点：
      - 形式简洁；
      - 若面试时不允许使用递归，则可使用栈模拟递归过程；
    - 缺点：
      - 递归中部分计算内容是重复的，造成不必要的时间开销，==可借助递归思想分析问题，使用迭代的思想自底向上求解==；
      - 每次函数调用时，都需要在内存栈中分配空间保存参数、返回地址和临时变量；
      - 由于每个进程的栈容量有限，若递归层数过多，则会造成栈溢出；



## 1.2 迭代
- 为什么不使用递归求解？
  - 递归求解 Fibonacci 数列时，会重复计算部分内容；
  - E.g. $f(10)=f(9)+f(8)​$，如需求解$f(10)​$，应先求$f(9)​$和$f(8)​$，而求解$f(9)​$的过程中，递归调用会再一次求解$f(8)​$；
  - 本题中若使用递归求解，则会超出时间限制；
- 难点：
  - Q1：两种方法的区别？
    - Approach 1：创建一个长度为n的数组，存放$f(1),f(2),...,f(n)$；
    - Approach 2：创建两个变量，用于保存 Fibonacci 数列中的前两项；
  - A1：Approach 2 能将空间复杂度从$O(n)​$减小至$O(1)​$；

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int lo = 1;
        int hi = 2;
        int ans = -1;
        while (n-- > 2) {
            ans = hi + lo;
            lo = hi;
            hi = ans;
        }
        return ans;
    }
}
```



# 2. LeetCode 509

## 2.1 复杂度分析
- LeetCode 509 和 70 、1137 的解题思路基本一致；



## 2.2 递归

- 难点：
  - Java 强制要求处理`Exception`（即含有`catch`语句），但对`RuntimeException`无强制要求；

```java
class Solution {
    public int fib(int N) {
        if (N < 0)
            throw new RuntimeException("Input N >= 0.");
        if (N <= 1)
            return N;
        return fib(N - 1) + fib(N - 2);
    }
}
```



## 2.3 迭代

```java
class Solution {
    public int fib(int N) {
        if (N < 0)
            throw new RuntimeException("Input N >= 0.");
        if (N <= 1)
            return N;
        int lo = 0;
        int hi = 1;
        int ans = -1;
        while (N-- > 1) {
            ans = hi + lo;
            lo = hi;
            hi = ans;
        }
        return ans;
    }
}
```



# 3. LeetCode 1137

## 2.1 复杂度分析

- LeetCode 1137 和 70 、509 的解题思路基本一致；



## 2.2 迭代

- 本题中若使用递归求解，则会超出时间限制；

```java
class Solution {
    public int tribonacci(int n) {
        if (n < 0)
            throw new RuntimeException("Input n >= 0.");
        if (n < 2)
            return n;
        int num0 = 0;
        int num1 = 1;
        int num2 = 1;
        int ans = 1;
        while (n-- > 2) {
            ans = num2 + num1 + num0;
            num0 = num1;
            num1 = num2;
            num2 = ans;
        }
        return ans;
    }
}
```



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.