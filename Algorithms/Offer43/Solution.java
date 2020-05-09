class Solution {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;         
        int low = 0;
        int curr = n % 10;
        int high = n / 10;
        int digit = 1;
        int res = 0;
        while (high != 0 || curr != 0) {
            switch (curr) {
                case 0: res += high * digit; break;
                case 1: res += high * digit + low + 1; break;
                default: res += (high + 1) *digit;
            }
            low += curr * digit;
            curr = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}