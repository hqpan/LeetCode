[TOC]

# 1. LeetCode 41

- 原地标记数组；

  - 时间复杂度$O(n)$，空间复杂度$O(1)$；

- 排序：可使用 Arrays.sort()；

  - 时间复杂度$O(nlogn)$，空间复杂度$O(logn)$；

- 新建一个长度为 n 的辅助数组，对数值 1-n 做标记；
  - 时间复杂度$O(n)$，空间复杂度$O(n)$；

# 2. 原地标记数组

- 四次遍历数组：
  - Step 1：检测数组中是否存在1；
    - 若其中不存在1，则1即为缺失的数字；
  - Step 2：将数组中所有小于等于0的值替换为1；
  - Step 3：以遍历到的值为索引，将对应的数组元素修改为负数，且绝对值不变，以符号表示数值是否存在；
  - Step 4：将检测到的第一个正数的索引加1，即为缺失的数字；
    - 若检测到的所有值均为复制，则将数组的长度 n 加1，即为缺失的数字；
- 示意图如下：
  - 用原数组自身作为标记数组，用数组中 0-n-1 上的元素表示数值 1-n 是否存在；
  - 标记的方法：将对应的数组元素修改为负数，且绝对值不变；
    - Why：相较于用布尔值表示数据的存在性，仅修改数值的正负号可避免将未读取的数据覆盖；

|     index      |   0    |   1   |   2    |   3    |   4    |  5   |
| :------------: | :----: | :---: | :----: | :----: | :----: | :--: |
| Original value |   3    |   4   |   1    |   -2   |   0    |  5   |
|     Step 2     |   3    |   4   |   1    | **1**  | **1**  |  5   |
|     Step 3     |        |       | **-1** |        |        |      |
|     Step 3     |        |       |        | **-1** |        |      |
|     Step 3     | **-3** |       |        |        |        |      |
|     Step 3     |        |       |        |        | **-1** |      |
|     Step 3     |   -3   |   4   |   -1   |   -1   |   -1   |  5   |
|     Step 4     |        | **4** |        |        |        |      |
