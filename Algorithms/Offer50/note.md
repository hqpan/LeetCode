[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 50

## 1.1 复杂度分析

- 哈希表：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 1.2 哈希表

- 解题思路：
  - 第一次遍历字符串中的每个字符：以字符为键，出现次数为值，存入哈希表中；
  - 第二次遍历字符串中的每个字符：查询该字符对应的出现次数，若出现次数为1，即为所求；

```java
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> st = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (st.containsKey(temp))
                st.put(temp, st.get(temp) + 1);
            else
                st.put(temp, 1);
        }
        for (int i = 0; i < s.length(); i++)
            if (st.get(s.charAt(i)) == 1)
                return s.charAt(i);
        return ' ';
    }
}
```

# 2. Summary

- ==无需复习==；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.