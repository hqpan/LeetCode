// Approach 1: Recursion
class Solution {
    private int n;
    private int maxValue;
    private double[] res;
    public double[] twoSum(int n) {
        if (n < 1)
            return new double[0];
        this.n = n;
        this.maxValue = 6;
        int maxSum = maxValue * n;
        res = new double[maxSum - n + 1];
        for (int i = 1; i <= maxValue; i++)
            compute(n, i);
        double total = Math.pow(maxValue, n);
        for (int i = 0; i < res.length; i++)
            res[i] /= total;
        return res;
    }
    public void compute(int count, int sum) {
        if (count == 1) {
            res[sum - n]++;
            return;
        }
        for (int i = 1; i <= maxValue; i++)
            compute(count - 1, sum + i);
    }
}

// Approach 2: Iteration
class Solution {
    public double[] twoSum(int n) {
        if (n < 1)
            return new double[0];
        int maxValue = 6;
        double[] res = new double[n * maxValue + 1];
        for (int i = 1; i <= maxValue; i++)
            res[i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i * maxValue; j >= i; j--) {
                res[j] = 0;
                for (int k = 1; k <= maxValue; k++) {
                    if (j - k >= i - 1)
                        res[j] += res[j - k];
                }
            }
        }
        double total = Math.pow(maxValue, n);
        for (int i = 1; i < res.length; i++)
            res[i] /= total;
        return Arrays.copyOfRange(res, n, n * maxValue + 1);
    }
}