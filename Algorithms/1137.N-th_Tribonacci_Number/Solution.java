class Solution {
    public int tribonacci(int n) {
        if (n < 0)
            throw new RuntimeException("Input n >= 0.");
        if (n < 2)
            return n;
        int num0 = 0;
        int num1 = 1;
        int num2 = 1;
        int ans = 1;
        while (n-- > 2) {
            ans = num2 + num1 + num0;
            num0 = num1;
            num1 = num2;
            num2 = ans;
        }
        return ans;
    }
}