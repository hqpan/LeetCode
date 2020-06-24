class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        int value1 = 0;
        int value2 = 1;
        int value3 = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = value1 + value2 + value3;
            value1 = value2;
            value2 = value3;
            value3 = sum;
        }
        return value3;
    }
}
