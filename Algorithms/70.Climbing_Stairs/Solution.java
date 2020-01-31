class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int lo = 1;
        int hi = 2;
        int ans = -1;
        while (n-- > 2) {
            ans = hi + lo;
            lo = hi;
            hi = ans;
        }
        return ans;
    }
}