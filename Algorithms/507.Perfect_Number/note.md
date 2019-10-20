[TOC]



# 1. LeetCode 507

- 暴力求解：从1-n 逐个确认是否满足完美数的定义；==No review required==

  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
  - Time Limit Exceeded；
- 优化后的暴力求解：

  - 时间复杂度：$O(\sqrt{n})$；
  - 空间复杂度：$O(1)$；
- Euclid-Euler 方法：==No review required==
  - 时间复杂度：$O(log\space n)$；
  - 空间复杂度：$O(log\space n)$；
- 备注：n 为输入的数值；

# 2. 优化后的暴力求解

- 求解流程：

  - “完美数”的因子成对出现，E.g. $num\div i=j$，因此可将暴力求解的时间复杂度从$O(n)$降低至$O(\sqrt{n})$；
- 边界条件：
  - 当因子$i=\sqrt{num}$时，i 只能被累加1次；



# 3. Euclid-Euler 方法

- 求解流程：参见维基百科[^1]；




# References

[^1]: https://en.wikipedia.org/wiki/Euclid%E2%80%93Euler_theorem.