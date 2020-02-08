[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 79
## 1.1 复杂度分析
- 题意解析：
  - 与单词搜索问题类似的问题，还有迷宫问题、在二维矩阵中的机器人路径问题；
  - 主函数：
    - 二维矩阵中的每个字符均可能作为待搜索字符串的首字母，故需遍历二维数组；
    - 对二维数组中的每个字符调用辅助函数，判断是否存在以该字符为首字母的目标字符串;
  - 辅助函数：
    - 建立一个与二维数组维度相等的布尔矩阵，用于标记某个值是否已被访问；
    - 若当前字符与目标字符串匹配，则标记布尔矩阵中的对应位置，并分别对上下左右四个方向的字符进行递归调用，判断是否满足要求；
    - 若当前字符与目标字符串不匹配，则将布尔矩阵中的标记值复原，并返回 false；



## 1.2 回溯
- 难点：
  - Q1：两种方法的区别？
    - Approach 1：创建一个布尔矩阵，用于标记已访问的区域；
    - Approach 2：在原矩阵上修改已访问的数据，并创建一个字符型变量暂存对应位置上的原始数据，待递归调用返回时，将该值复原；
  - A1：Approach 2 不增加额外的空间开销；

```java
class Solution {
    char[][] board;
    boolean[][] visited;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        int rows = board.length;
        int columns = board[0].length;
        int length = 0;
        visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++)
                if (find(row, column, length))
                    return true;
        }
        return false;
    }

    public boolean find(int row, int column, int length) {
        if (length == word.length())
            return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column] || board[row][column] != word.charAt(length))
            return false;
        visited[row][column] = true;
        boolean ans = find(row - 1, column, length + 1) || 
            find(row + 1, column, length + 1) ||
            find(row, column - 1, length + 1) || 
            find(row, column + 1, length + 1);
        visited[row][column] = false;
        return ans;
    }
}
```



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.