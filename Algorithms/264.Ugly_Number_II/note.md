[TOC]



# 1. LeetCode 264

- 暴力求解：`超出时间限制`（Time limit exceeded）；
  - 从1开始遍历，逐个检查是否为“丑数”，直至找出第n个丑数；
  - 缺陷：需要检查大量不满足“丑数”条件的数值；
- 动态规划：合并三个子序列；
  - Approach 1：创建三个数组，分别对`ans[]`乘以2、3、5；
    - 缺陷：求解的“丑数”数量大于 n 个，增加了不必要的时间开销；
  - Approach 2：使用三个索引，分别对`ans[]`乘以2、3、5；



# 2. Approach 1：创建三个数组

- 关于数据溢出引发的问题：整型变量用于表示有符号数的范围是`[-2147483648, 2147483647]`；

  - 观察现象：观察到输出值为负数，数值接近`-2147483648`，结合本题条件可知不应出现负值，初步推断为数据溢出；
  - 原因及解决方案：创建三个数组，生成的“丑数”数量超过了 n 个，数值不断增大；此时使用整型变量不能表示这些数值，因此需要使用长整型变量；
  



# 3. Approach 2： 使用三个索引

- 分析：
  - 暴力搜索需要检查大量不满足“丑数”要求的数值，因此可尝试生成“丑数”，以减少时间开销；
  - “丑数”至少含有因数1，在此基础上不断乘以2 、3、5，可生成各个“丑数”；
  - 创建一个长度为n的数组，存放前n个“丑数”，使用三个索引，将三个子序列中的“丑数”合并为一个序列；

|  Num2  |  Num3  |  Num5  | uglyNum |
| :----: | :----: | :----: | :-----: |
|        |        |        |    1    |
|   2    |   3    |   5    |    2    |
| **4**  |        |        |    3    |
|        | **6**  |        |    4    |
| **6**  |        |        |    5    |
|        |        | **10** |    6    |
| **8**  | **9**  |        |    8    |
| **10** |        |        |    9    |
|        | **12** |        |   10    |
|  ...   |  ...   |  ...   |   ...   |
