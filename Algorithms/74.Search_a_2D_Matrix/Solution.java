// LeetCode 74
// binary search
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