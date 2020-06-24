// Solution of Offer 10-I
class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int lo = 0;
        int hi = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (lo + hi) % 10_0000_0007;
            lo = hi;
            hi = sum;
        }
        return hi;
    }
}

// Solution of Offer 10-II
class Solution {
    public int numWays(int n) {
        int lo = 1;
        int hi = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (lo + hi) % 10_0000_0007;
            lo = hi;
            hi = sum;
        }
        return hi;
    }
}
