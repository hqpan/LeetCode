[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 946 & 剑指 Offer 31
- 模拟栈操作：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 31；

# 2. 模拟栈操作
- 解题思路：
  - 元素入栈的顺序必定是输入数组的顺序；
  - 元素出栈的时刻，可为任意一次元素入栈之后；
  - 因此使用二重循环：
    - 外循环：将元素逐个入栈；
    - 内循环：
      - 每次元素入栈后，检测是否满足弹出条件；
      - 若满足弹出条件，则将所有满足条件的元素弹出；

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int pushNum : pushed) {
            stack.push(pushNum);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                ++index;
            }
        }
        return stack.isEmpty();
    }
}
```

# 3. Summary

- 参见模拟栈操作的解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.