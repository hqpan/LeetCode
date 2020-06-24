class Solution {
    public int fib(int N) {
        if (N == 0)
            return 0;
        int lo = 0;
        int hi = 1;
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            sum = lo + hi;
            lo = hi;
            hi = sum; 
        }
        return hi;
    }
}
