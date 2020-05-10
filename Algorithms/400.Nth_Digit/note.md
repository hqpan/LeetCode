[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 400 & 剑指 Offer 44

## 1.1 复杂度分析

- 相同的问题：剑指 Offer 44；
- 数学分析：
  - 时间复杂度：$O(logn)$；
  - 空间复杂度：$O(1)$；

## 1.2 数学分析

| 数值区间 | 数值位数 |
| :------: | :------: |
|   1-9    |    1     |
|  10-99   |    2     |
| 100-999  |    3     |
|   ...    |   ...    |

- 解题思路：
  - 循环：判断输入数据所处区间；
  - 得到输入数据在区间内的偏移值；
  - 根据偏移值求得对应的数、对应于该数中的某一位；

```java
class Solution {
    public int findNthDigit(int n) {
        int bit = 1;
        long digit = 1;
        long count = 9;
        while (count < n) {
            n -= count;
            bit++;
            digit *= 10;
            count = 9 * bit * digit;         
        }
        long num = digit + (n - 1) / bit;
        return Long.toString(num).charAt((n - 1) % bit) - '0'; 
    }
}
```

# 2. Summary

- 参见 LeetCode 400 解题思路；
- 算法细节：
  - 累加 count，然后与 n 值比较，该方式需要额外计算1次偏移值；
  - 使用`n -= count`的方式修改 n 值，循环结束后即可得区间内偏移值；
  - 求`int`、`long`类型数值中某一位的值：
    - `public static String toString(int i)`：将整型值转换为字符串；
    - `public static String toString(long i)`：将长整型值转换为字符串；
    - `public char charAt(int index)`：以字符的形式返回某一位上的值；
    - `return ans - '0'`：即可得对应的整数值；
    - ==注意==：此处不可使用`(int) ans`，该语句将返回 ASCII 码对应的整数值，而非字符表示的整数值；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.