[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 74
## 1.1 复杂度分析
- 二分法：
  - 时间复杂度：$O(log(mn))$；
  - 空间复杂度：$O(1)$；
- 解题思路：
  - 每行中的数据从左向右递增；
  - 每行中的最后一个数大于下一行中的第一个数；
  - 该二维数组中的数据关系类似于一个一维数组中的数据关系；
  - 使用二分法求解；

## 1.2 二分法
- 难点：
  - Q1：两种方法的区别？
    - Approach 1：给定两个数在矩阵中的索引，求中点的索引；
    - Approach 2：给定1和$m\times n$，求中点索引；
  - A1：Approach 2 实现数值与索引转换的计算量更小；
  - Q2：进行边界条件检测时，为什么只检测矩阵的行数是否为0，而不检测列数是否为0？
  - A2：若一个矩阵的行数为0，则列数必为0，两者等价；
  - 考虑所有传入参数是否合理：`int[][] matrix`是否为空，`matrix == null`；

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int lo = 1;
        int hi = matrix.length * matrix[0].length;
        while (lo <= hi)
        {
            int mid = (hi + lo) / 2;
            int row = (mid - 1) / matrix[0].length;
            int column = (mid - 1) % matrix[0].length;
            int temp = matrix[row][column];
            if (target == temp)
                return true;
            if (target < temp)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}
```

# 2. LeetCode 240
## 2.1 复杂度分析
- LeetCode 240 和 74 的不同之处：数据之间的大小关系不同；
- 暴力搜索：
  - 时间复杂度：$O(log(mn))$；
  - 空间复杂度：$O(1)$；
  - 缺点：未利用数据之间的大小关系，时间开销大；
- 二分法：选取对角线上的元素，对行和列使用二分法：
- 分治：根据中间列定位目标值所在行，将原矩阵拆分为四个子矩阵，并对其中两个子矩阵重复该操作；
- 每次排除一行或一列；
  - 时间复杂度：$O(log(m + n))$；
  - 空间复杂度：$O(1)$；

## 2.2 每次排除一行或一列
- 解题思路：
  - 矩阵中右上角的数，大于该行中的所有值，小于该列中的所有值；
  - 将目标值与矩阵中右上角的数作比较，必能排除一行或一列；
  - 缩小筛选范围，直至检测到目标值或所有元素均被排除；
  - 矩阵中右上角与左下角元素的作用等价；

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0)
        {
            if (matrix[row][column] == target)
                return true;
            if (matrix[row][column] > target)
                --column;
            else
                ++row;
        }
        return false;
    }
}
```

# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.