[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 54 & 剑指 Offer 29

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 29；

# 2. 递归

- 解题思路：
  - 定义4个变量，限制当前遍历的上下左右范围；
  - 每次遍历矩阵1圈；

```java
// Approach 1: Recursion
class Solution {
    ArrayList<Integer> array = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return array;
        outputNum(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
        return array;
    }

    public void outputNum(int[][] matrix, int left, int right, int up, int down) {
        if (left > right || up > down)
            return;
        for (int i = left; i <= right; i++)
            array.add(matrix[up][i]);
        for (int i = up + 1; i <= down; i++)
            array.add(matrix[i][right]);
        
        if (up < down && left < right) {
            for (int i = right - 1; i >= left; i--)
                array.add(matrix[down][i]);
            for (int i = down - 1; i >= up + 1; i--)
                array.add(matrix[i][left]);
        }
        outputNum(matrix, ++left, --right, ++up, --down);
    }
}
```

# 3. 迭代
- 解题思路：同递归；

```java
// Approach 2: Iteration
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++)
                ans.add(matrix[up][i]);
            for (int i = up + 1; i <= down; i++)
                ans.add(matrix[i][right]);
            if (left < right && up < down) {
                for (int i = right - 1; i >= left; i--)
                    ans.add(matrix[down][i]);
                for (int i = down - 1; i >= up +1; i--)
                    ans.add(matrix[i][left]);
            }
            ++left;
            --right;
            ++up;
            --down;
        } 
        return ans;
    }
}
```

# 4. Summary

- 无需复习；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.