// Approach 1: 逐次去除最右侧的1
class Solution {
    public int hammingDistance(int x, int y) {
        if (x < 0 || y < 0)
            throw new RuntimeException("x and y should be positive.");
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count++;
            xor &= xor - 1;            
        }
        return count;
    }
}

// Approach 2: 使用内建方法 bitCount
class Solution {
    public int hammingDistance(int x, int y) {
        if (x < 0 || y < 0)
            throw new RuntimeException("x and y should be positive.");
        return Integer.bitCount(x ^ y);
    }
}