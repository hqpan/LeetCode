[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 50
## 1.1 复杂度分析
- 题意解析：
  - 考察内容：
    - 快速幂算法；
    - 递归、迭代；
    - 考虑输入参数不同的情况下程序的鲁棒性；
  - 与实现库函数`pow(x,n)`问题相同的问题，还有剑指 Offer 16；
- 暴力求解：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 递归：
  - 时间复杂度：$O(log(n))$；
  - 空间复杂度：$O(log(n))$；
- 迭代：
  - 时间复杂度：$O(log(n))$；
  - 空间复杂度：$O(1)$；



## 1.2 递归
- 解题思路：
  - 考虑输入值所有可能的组合如下表所示；
  - 若$x=0,n<0$，则为不合理输入，可抛出异常；
  - 若$n=0$，则返回1；
  - 若$x\neq0,n<0$，则令$x=\frac{1}{x},n=-n$，则可将负次幂转换为正次幂处理；
  - 若$n\geqslant 0$，则递归调用快速幂方法即可；

|  x   |  n   |          备注          |
| :--: | :--: | :--------------------: |
|  +   |  +   |                        |
|  0   |  +   |                        |
|  -   |  +   |                        |
|  +   |  0   |           1            |
|  0   |  0   |           1            |
|  -   |  0   |           1            |
|  +   |  -   | 负次幂转换为正次幂处理 |
|  0   |  -   |       不合理输入       |
|  -   |  -   | 负次幂转换为正次幂处理 |

- 递归表达式：
  - 若 n 为偶数，则$x^n=x^{\frac{n}{2}}\cdot x^{\frac{n}{2}}$；
  - 若 n 为奇数，则$x^n=x^{\frac{n}{2}}\cdot x^{\frac{n}{2}} \cdot x$；
- 难点：int 取反时溢出；
  - int 的表示范围为$[-2^{31}.2^{31}-1]$；
  - $-2^{31}$的二进制表示为10000000_00000000_00000000_00000000；
  - 若直接将 Integer.MIN_VALUE 取反，则所得结果为0；
  - 若对 Integer.MIN_VALUE 使用`public static int abs(int a)`，该方法将返回 Integer.MIN_VALUE；
  - 因此需要定义一个 long 类型的变量，即可实现32位整数的取反操作；

```java
// Approach 1: Recursion
class Solution {
    public double myPow(double x, int n) {
        if (n < 0 && Double.toString(x).equals(Double.toString(0)))
            throw new RuntimeException("The exponent of zero cannot be negative.");
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public double fastPow(double x, long N) {
        if (N == 0)
            return 1;
        double ans = fastPow(x, N >>> 1);
        ans *= ans;
        if ((N & 1) == 1)
            ans *= x;
        return ans;
    }
}
```



## 1.3 迭代

- 迭代与递归的不同之处：使用快速幂算法取代了递归过程；
- 快速幂算法：E.g. 求解$x^{11}$；
  - $11=0B1011=1\times 2^3+0\times 2^2+1\times 2^1 + 1\times 2^0$；
  - 由题意可知，幂次为 n，且通过转换可使得幂次为非负数；
  - 定义一个变量 product，在循环过程中依次计算 x 的偶次幂值；
  - 定义一个变量$ans=1$，从右向左检测 n 二进制表示形式中的每一位；
    - 若该$bit=1$，则令$ans=ans*product$；
    - 若该$bit=0$，则不改变 ans 的值；
  - 优点：时间开销小于循环累乘；
    - 循环累乘的时间复杂度：$O(n)$；
    - 快速幂算法的时间复杂度：$O(log(n))$；

```java
// Approach 2: Iteration
class Solution {
    public double myPow(double x, int n) {
        if (n < 0 && Double.toString(x).equals(Double.toString(0)))
            throw new RuntimeException("The exponent of zero cannot be negative.");
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double product = x;
        while (N > 0) {
            if ((N & 1) == 1)
                ans *= product;
            product *= product;
            N = N >>> 1;
        }
        return ans;
    }
}
```



# 2. 剑指 Offer 16

- 求解思路与 LeetCode 50 相同；



# 3. Summary

## 3.1 数学

- 底数为0：
  - $0^0=1$；
  - 0的负数次幂无意义；



## 3.2 Java 语法

- 判断小数相等的方法：

  - 由于精度问题，不能使用`==`判断小数是否相等；
  - Approach 1：判断两数之差是否小于一个较小值；
  - Approach 2：调用`public static String toString(double d)`方法，将浮点数转换为 Double 对象后，使用`equals()`方法比较；
- 位运算：
  - 位运算的效率高于乘除运算：E.g. 使用右移运算取代除以2；
  - 位运算的效率高于取余运算：E.g. 如需对2取余，则将待处理的数值value执行按位与，`value&1`；
- int 取反时溢出：
  - int 的表示范围为$[-2^{31}.2^{31}-1]$；
  - $-2^{31}$的二进制表示为10000000_00000000_00000000_00000000；
  - 若直接将 Integer.MIN_VALUE 取反，则所得结果为0；
  - 若对 Integer.MIN_VALUE 使用`public static int abs(int a)`，该方法将返回 Integer.MIN_VALUE；
  - 因此需要定义一个 long 类型的变量，即可实现32位整数的取反操作；
- Java 中不同进制数值的书写方法：
  - 二进制：0b1011，以0b开头，字母b不区分大小写；
  - 八进制：013，以数字0开头；
  - 十六进制：0xB，以0x开头，字母x和表示数值10-15的字母均不区分大小写；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.