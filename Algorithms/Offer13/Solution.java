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
