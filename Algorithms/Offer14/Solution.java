// Offer 14-I
// Approach 1: Dynamic programming
class Solution {
    public int cuttingRope(int n) {
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
            for (int j = 1; j <= i / 2; j++)
                if (product[j] * product[i - j] > max)
                    max = product[j] * product[i - j];
            product[i] = max;
        }
        return product[n];
    }
}

// Offer 14-I
// Approach 2: Greedy algorithm
class Solution {
    public int cuttingRope(int n) {
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

// Offer 14-II
// Approach 1: Dynamic programming
import java.math.BigDecimal;
class Solution {
    public int cuttingRope(int n) {
        if (n < 1)
            throw new RuntimeException("Input error: n < 1.");
        if (n <= 3)
            return n - 1;
        BigDecimal[] product = new BigDecimal[n + 1];
        product[1] = new BigDecimal(1);
        product[2] = new BigDecimal(2);
        product[3] = new BigDecimal(3);
        for (int i = 4; i <= n; i++) {
            BigDecimal max = new BigDecimal(0);
            for (int j = 1; j <= i / 2; j++)
                if (product[j].multiply(product[i - j]).compareTo(max) > 0)
                    max = product[j].multiply(product[i - j]);
            product[i] = max;
        }
        BigDecimal mod = new BigDecimal(1_000_000_007);
        return product[n].remainder(mod).intValue();
    }
}

// Offer 14-II
// Approach 2: Greedy algorithm
import java.math.BigDecimal;
class Solution {
    public int cuttingRope(int n) {
        if (n < 1)
            throw new RuntimeException("Input error: n < 1.");
        if (n <= 3)
            return n - 1;
        int quotient = n / 3;
        int remainder = n % 3;
        BigDecimal two = new BigDecimal(2);
        BigDecimal three = new BigDecimal(3);
        BigDecimal four = new BigDecimal(4);
        BigDecimal mod = new BigDecimal(1_000_000_007);
        if (remainder == 0)
            return three.pow(quotient).remainder(mod).intValue();
        if (remainder == 1)
            return three.pow(quotient - 1).multiply(four).remainder(mod).intValue();
        return three.pow(quotient).multiply(two).remainder(mod).intValue();
    }
}