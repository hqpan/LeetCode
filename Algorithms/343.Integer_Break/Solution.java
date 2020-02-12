// Approach 1: Dynamic programming
class Solution {
    public int integerBreak(int n) {
        if (n <= 1)
            throw new RuntimeException("Input error: n <= 1.");
        if (n <= 3)
            return n - 1;
        int[] product = new int[n + 1];
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++)
                if (product[j] * product[i - j] > max)
                    max = product[j] * product[i - j];
            product[i] = max;
        }
        return product[n];
    }
}

// Approach 2: Greedy algorithm
class Solution {
    public int integerBreak(int n) {
        if (n <= 1)
            throw new RuntimeException("Input error: n <= 1.");
        if (n <= 3)
            return n - 1;
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0)
            return (int) Math.pow(3, quotient);
        if (remainder == 1)
            return (int) Math.pow(3, quotient - 1) * 4;
        return (int) Math.pow(3, quotient) * 2;
    }
}