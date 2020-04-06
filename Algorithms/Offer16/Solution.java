// Approach 1: Recursion
class Solution {
    public double myPow(double x, int n) {
        if (n < 0 && Double.toString(x).equals(Double.toString(0)))
            throw new RuntimeException("The exponent of zero cannot be negative.");
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public double fastPow(double x, long N) {
        if (N == 0)
            return 1;
        double ans = fastPow(x, N >>> 1);
        ans *= ans;
        if ((N & 1) == 1)
            ans *= x;
        return ans;
    }
}

// Approach 2: Iteration
class Solution {
    public double myPow(double x, int n) {
        if (n < 0 && Double.toString(x).equals(Double.toString(0)))
            throw new RuntimeException("The exponent of zero cannot be negative.");
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double product = x;
        while (N > 0) {
            if ((N & 1) == 1)
                ans *= product;
            product *= product;
            N = N >>> 1;
        }
        return ans;
    }
}