[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 3 & 剑指 Offer 48

## 1.1 复杂度分析

- DP+哈希表：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 相同问题：剑指 Offer 48；

## 1.2 DP+哈希表

- 解题思路：
  - 状态：
    - $dp[i]$以当前字符结尾的，最长非重复字符串长度；
    - 空间优化：使用滚动数组、打擂算法，借助单一变量取代$dp[]$；
  - 状态转移方程：
    - 创建哈希表，保存字符及其首次出现索引；
    - 若哈希表中不含当前字符，则字符串长度加1；
    - 若哈希表中含有当前字符，则根据当前字符串长度、当前字符索引、当前字符在哈希表中重复字符的索引，即可得出重复字符的位置关系；
      - 重复字符位于当前字符串之前，则字符串长度加1；
      - 重复字符位于当前字符串之中，则字符串长度为重复字符索引之差；
  - 优化：通过判断重复字符的位置关系，避免删除哈希表中不属于当前字符串的元素，减少时间开销；

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        int currMax = 0;
        int res = 0;
        HashMap<Character, Integer> st = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!st.containsKey(temp) || i - st.get(temp) > currMax) {
                currMax++;
                res = Math.max(currMax, res);            
            } else {
                res = Math.max(currMax, res);
                currMax = i - st.get(temp);
            }
            st.put(temp, i);
        }
        return res;
    }
}
```

# 2. Summary

- 参见 LeetCode 3  解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.