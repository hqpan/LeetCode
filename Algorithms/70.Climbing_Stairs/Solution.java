class Solution {
    public int climbStairs(int n) {
        int lo = 1;
        int hi = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = lo + hi;
            lo = hi;
            hi = sum;
        }
        return hi;
    }
}
