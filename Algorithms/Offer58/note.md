[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 151 & 剑指 Offer 58-I

## 1.1 复杂度分析

- `split`切分字符串：==无需复习==
  
  - 时间复杂度：$O(n)$；
  
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 58-I；

## 1.2 split 切分字符串

- 解题思路：
  - 使用`split`方法，将字符串切分为字符串数组；
  - 由高位至低位遍历字符串数组，将字符串依次连接，即为所求；
- 难点：
  - 字符串数组中，有部分字符串仅含有若干空格，E.g. $\space \space \space$；
  - 仅含有空格的字符串不应添加至最终结果中；

```java
class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return s;
        String[] str = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--)
            if (!str[i].trim().equals(""))
                builder.append(str[i].trim() + " ");
        return builder.toString().trim();
    }
}
```

# 2. 剑指 Offer 58-II

## 2.1 复杂度分析

- 字符串切片：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 2.2 字符串切片

- 解题思路：
  - `public String substring(int beginIndex)`：截取起始索引至字符串结尾的字符；
  - `public String substring(int beginIndex, int endIndex)`：截取起始索引至`endIndex - 1`的字符；
  - 注意：`substring`方法的索引从0开始计数；

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || n < 0)
            throw new RuntimeException("Invalid input!");
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
```

# 3. Summary

- 无需复习；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.