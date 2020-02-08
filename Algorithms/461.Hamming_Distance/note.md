[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 191
## 1.1 复杂度分析
- 题意解析：
  - 考察内容：位运算；
  - 汉明重量：hamming weight，一串符号中非零符号的个数，本题中指二进制数中各比特位上1的个数；
  - 与求解汉明重量问题类似的问题，还有判断一个数是否为2的幂（LeetCode 231）、求解汉明距离（LeetCode 461）；
- 循环对2取余并除以2：除法运算效率低于移位运算效率，该方法不可取；
  - 时间复杂度：
    - 最坏情况下时间复杂度：$O(n)$；
    - 最好情况下时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)​$；
- 逐位移动 mask：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)​$；
- 逐位移动目标值：
  - 时间复杂度：
    - 最坏情况下时间复杂度：$O(n)$；
    - 最好情况下时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)$；
- 逐次去除最右侧的1：
  - 时间复杂度：
    - 最坏情况下时间复杂度：$O(n)$；
    - 最好情况下时间复杂度：$O(1)​$；
  - 空间复杂度：$O(1)​$；



## 1.2 逐位移动 mask
- 解题思路：
  - 以整数1作为 mask，与目标数值做`&`运算，判断目标值在当前比特位上是否为1；
  - 将 mask 左移一位，重复上述步骤；
  - 统计值为1的比特位数量，即为所求；

```java
// Approach 1: 逐位移动mask
public class Solution {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                count++;
            mask = mask << 1;
        }
        return count;
    }
}
```



## 1.3 逐位移动目标值

- 解题思路：
  - 以整数1作为 mask，与目标数值做`&`运算，判断目标值在当前比特位上是否为1；
  - 将目标值右移一位，重复上述步骤；
  - 统计值为1的比特位数量，即为所求；

```java
// Approach 2: 逐位移动n
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                count++;
            n = n >>> 1;
        }
        return count;
    }
}
```





## 1.4 逐次去除最右侧的1

- 解题思路：
  - 若存在一个整数 num，则`num&(num-1)`可去除 num 二进制表示形式中最右侧的1；
  - 重复上述步骤并计数，直至 num 为0；

```java
// Approach 3: 逐次取最右侧的1
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
```



# 2. LeetCode 231

## 2.1 复杂度分析

- 题意解析：
  - 考察内容：位运算；
  - 若一个数为2的幂次方，则该数的二进制表示形式中，仅有一个比特位的值为1；
- 循环对2取余并除以2：除法运算效率低于移位运算效率，该方法不可取；
  - 时间复杂度：
    - 最坏情况下时间复杂度：$O(n)$；
    - 最好情况下时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)​$；
- 逐位移动 mask：同 LeetCode 191；
  - 时间复杂度：$O(n)​$；
  - 空间复杂度：$O(1)​$；
- 逐位移动目标值：同 LeetCode 191；
  - 时间复杂度：
    - 最坏情况下时间复杂度：$O(n)$；
    - 最好情况下时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)$；
- 取最右侧的1：
  - 时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)​$；
- 去除最右侧的1：
  - 时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)$；



## 2.2 取最右侧的1

- 解题思路：
  - 若存在一个整数 num，则`num&(-num)`仅保留 num 二进制表示形式中最右侧的1；
  - 若目标值为2的幂次方，则取最右侧的1后，运算结果与运算前结果相等；

```java
// Approach 1: 取最右侧的1
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (-n)) == n;
    }
}
```



## 2.3 去除最右侧的1

- 若存在一个整数 num，则`num&(num-1)`可去除 num 二进制表示形式中最右侧的1；
- 若目标值为2的幂次方，则去除最右侧的1后，运算结果为0；

```java
// Approach 2: 去除最右侧的1
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
}
```



# 3. LeetCode 461

## 3.1 复杂度分析

- 题意解析：
  - 考察内容：位运算；
  - 汉明距离：hamming distance，两个相同长度的二进制数中，对应比特位不相等的数量；
- 逐次去除最右侧的1：同 LeetCode 191；
  - 时间复杂度：
    - 最坏情况下时间复杂度：$O(n)$；
    - 最好情况下时间复杂度：$O(1)$；
  - 空间复杂度：$O(1)$；
- 使用内建方法bitCount：`public static int bitCount(int i)`；



## 3.2 逐次去除最右侧的1

- 解题思路：
  - 对题中给出的2个整型参数执行异或运算，则运算结果的二进制形式即可表示2个参数上不同的比特位；
  - 若2个参数对应的比特位不同，则运算结果中对应的比特位值为1；
  - 若2个参数对应的比特位相同，则运算结果中对应的比特位值为0；
  - 不妨将运算结果记为 num，则`num&(num-1)`可去除 num 二进制表示形式中最右侧的1，重复该步骤并计数，直至 num 为0，计数结果即为所求；

```java
// Approach 1: 逐次去除最右侧的1
class Solution {
    public int hammingDistance(int x, int y) {
        if (x < 0 || y < 0)
            throw new RuntimeException("x and y should be positive.");
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count++;
            xor &= xor - 1;            
        }
        return count;
    }
}
```



## 3.3 使用内建方法 bitCount

- 解题思路：
  - 同3.2中使用异或运算的结果表示2个参数上不同的比特位；
  - 使用内建方法 bitCount 统计异或运算结果中值为1的比特位数量；

```java
// Approach 2: 使用内建方法 bitCount
class Solution {
    public int hammingDistance(int x, int y) {
        if (x < 0 || y < 0)
            throw new RuntimeException("x and y should be positive.");
        return Integer.bitCount(x ^ y);
    }
}
```



# 4. Summary

## 4.1 位运算方法

- 位运算方法：
  - 去除二进制形式中最右侧的1：若存在一个整数 num，则`num&(num-1)`可去除 num 二进制表示形式中最右侧的1；
  - 获取二进制形式中最右侧的1：若存在一个整数 num，则`num&(-num)`仅保留 num 二进制表示形式中最右侧的1；



## 4.2 Java 语法

- 两种位运算符的区别？
  - `>>`：算数右移，亦称有符号右移，高位用符号位填充；
  - `>>>`：逻辑右移，亦称无符号右移：高位用0填充；
- 有符号整数：Java 编译器中使用二进制补码表示有符号整数；
  - E.g. -1的二进制表示为`1111_1111_1111_1111_1111_1111_1111_1111`；
  - 若对-1执行`>>`运算，结果仍为-1；
- 常考察的符号：`==`运算符的优先级高于部分逻辑运算符和位运算符；
  - `~`：非；
  - `^`：异或；
  - `<<`：左移；
  - `>>`：有符号右移；
  - `>>>`：无符号右移；
- 异或的缩写：xor，abbr. 异或；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.