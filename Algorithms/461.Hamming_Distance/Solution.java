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
