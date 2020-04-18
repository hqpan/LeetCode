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