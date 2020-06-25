// Approach 1: compute per bit
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}

// Approach 2: n & (n - 1)
public class Solution {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        while (n != 0) {
            if ((n & mask) != 0)
                count++;
            n = n >>> 1;
        }
        return count;
    }
}
