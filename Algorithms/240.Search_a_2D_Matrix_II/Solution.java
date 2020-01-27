// LeetCode 240
// 每次排除一行或一列
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