// Approach 1: ȡ���Ҳ��1
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (-n)) == n;
    }
}

// Approach 2: ȥ�����Ҳ��1
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
}