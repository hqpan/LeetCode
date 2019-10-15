[TOC]



# 1. LeetCode 645

- 暴力搜索：==No review required==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 排序：以快速排序为例；==No review required==
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(logn)$；
- 创建并行数组做标记：==No review required==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 原地标记数组：==No review required==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 拆分数据后执行异或运算：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；



# 2. 拆分数据后执行异或运算

- 求解步骤[1] ：

  - 第1次、第2次遍历数组：对数值 1-n 及数组中的所有元素执行按位异或运算；

    - 运算结果等价于 missing number 与 duplicated number 执行异或运算的值；
  - 求解 rightMostBit，即将 missing number 与 duplicated number 以二进制形式表示时，两者不同的某一个 bit；

    - E.g. missing number: 3(011B), duplicated number: 4(100B);
    - 在上述案例中，rightMostBit 只需指出两个数值之间某个不同的 bit 即可，因此可能的取值有100、010、001，取任意一个满足条件的值即可；
    - 求解 rightMostBit 的方法：不妨记第一步中异或运算的结果为`XOR`，则`rightMostBit = XOR & (~(XOR - 1))`；==可使用实例验证该式==
  - 第3次、第4次遍历数组：将数值 1-n 及数组中的所有元素分成两个集合；

    - 划分的标准：rightMostBit 对应的 bit 是否为1；
    - 对两个集合中的所有元素各自执行异或运算，将结果分别记为`XOR1`、`XOR2`；
    - 划分为两个集合的意义：将 missing number 与 duplicated number 分别放入两个集合之中，missing number 仅出现一次，duplicated number 则出现三次，其余数值均成对出现在某一个集合之中，因此对两个集合分别执行异或运算，即可求得 missing number 与 duplicated number，但无法判断哪一个数值为 missing number 或 duplicated number；
  - 第5次遍历数组：找出 missing number 与 duplicated number；
    - 两者的不同之处：duplicated number 是数组中的元素，而 missing number 仅在 1-n 中出现一次；

- 注意事项：
  
  - 恒等运算符`==`的优先级高于位运算符；



# Reference

[1] vinod23. Solution of LeetCode 645: Set Mismatch[DB/OL]. https://leetcode.com/articles/set-mismatch/, 2017-08-01/2019-09-27.