[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. 剑指 Offer 13
## 1.1 复杂度分析
- DFS：
  - 时间复杂度：$O(mn)$；
  - 空间复杂度：$O(mn)$；
- DP：
  - 时间复杂度：$O(mn)$；
  - 空间复杂度：$O(mn)$；

## 1.2 DFS
- 解题思路：
  - 若已知当前元素的位置坐标，由题中规则，可判断当前元素是否可被访问；
  - 对上下左右四个方向做 DFS；

```java
// Approach 1: DFS
class Solution {
    private int count;
    private int[][] visited;

    public int movingCount(int m, int n, int k) {
        this.count = 0;
        this.visited = new int[m][n];
        dfs(0, 0, m, n, k);
        return count;
    }

    public void dfs(int x, int y, int m, int n, int k) {
        if (check(x, y, m, n, k)) {
            count++;
            visited[x][y] = 1;
            dfs(x - 1, y, m, n, k);
            dfs(x + 1, y, m, n, k);
            dfs(x, y - 1, m, n, k);
            dfs(x, y + 1, m, n, k);
        }
    }

    public boolean check(int x, int y, int m, int n, int k) {
        boolean condition1 = (0 <= x) && (x < m) && (0 <= y) && (y < n) && (visited[x][y] == 0); 
        boolean condition2 = (getSum(x) + getSum(y)) <= k;
        return condition1 && condition2;
    }

    public int getSum(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }
}
```

## 1.3 DP

- 解题思路：
  - 分析矩阵中的坐标规律可知，仅考虑向右、向下两个方向上的搜索即可；
  - 使用 DP 求解即可；
- 难点：在 DP 解法中，对矩阵中元素位置关系的分类：
  - $i==0,j==0$；
  - $i>0$；
  - $j>0$；
  - 注意：$i>0,j>0$包含在第 2、3 种情况中，被计算 2 次；

```java
// Approach 2: DP
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;    
        int count = 0;
        int[][] visited = new int[m][n];        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {                
                if (i == 0 && j == 0)
                    visited[i][j] = 1;
                if ((getSum(i) + getSum(j) > k))
                    continue;
                if (i > 0)
                    visited[i][j] |= visited[i - 1][j];
                if (j > 0)
                    visited[i][j] |= visited[i][j - 1];
                count += visited[i][j];
            }
        }
        return count;
    }

    public int getSum(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }
}
```

# 2. Summary

- 在 DP 解法中，对矩阵中元素位置关系的分类：
  - $i==0,j==0$；
  - $i>0$；
  - $j>0$；
  - 注意：$i>0,j>0$包含在第 2、3 种情况中，被计算 2 次；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.