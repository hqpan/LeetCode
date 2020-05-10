class Solution {
    public int findNthDigit(int n) {
        int bit = 1;
        long digit = 1;
        long count = 9;
        while (count < n) {
            n -= count;
            bit++;
            digit *= 10;
            count = 9 * bit * digit;         
        }
        long num = digit + (n - 1) / bit;
        return Long.toString(num).charAt((n - 1) % bit) - '0';
    }
}