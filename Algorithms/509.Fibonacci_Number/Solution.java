// Approach 1: Recursion
class Solution {
    public int fib(int N) {
        if (N < 0)
            throw new RuntimeException("Input N >= 0."); // RuntimeExceptionÎÞÐècatch
        if (N <= 1)
            return N;
        return fib(N - 1) + fib(N - 2);
    }
}

// Approach 2: Iteration
class Solution {
    public int fib(int N) {
        if (N < 0)
            throw new RuntimeException("Input N >= 0.");
        if (N <= 1)
            return N;
        int lo = 0;
        int hi = 1;
        int ans = -1;
        while (N-- > 1) {
            ans = hi + lo;
            lo = hi;
            hi = ans;
        }
        return ans;
    }
}