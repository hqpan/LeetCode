// Approach 1: 遍历字符串
class Solution {
    public int translateNum(int num) {
        if (num < 0)
            throw new RuntimeException("Invalid input!");
        String str = String.valueOf(num);
        int step2 = 1;
        int step1 = 1;
        int res = 1;
        for (int i = 2; i <= str.length(); i++) {
            int value = Integer.parseInt(str.substring(i - 2, i));
            res = (10 <= value && value <= 25) ? step2 + step1 : step1;
            step2 = step1;
            step1 = res;
        }
        return res;
    }
}

// Approach 2: 数值取余
class Solution {
    public int translateNum(int num) {
        if (num < 0)
            throw new RuntimeException("Invalid input!");
        int step2 = 1;
        int step1 = 1;
        int bit2 = num % 10;
        int bit1 = 0;
        int res = 1;
        while (num != 0) {
            num /= 10;
            bit1 = num % 10;
            int value = bit1 * 10 + bit2;
            res = (10 <= value && value <= 25) ? step2 + step1 : step1;
            step2 = step1;
            step1 = res;
            bit2 = bit1;
        }
        return res;
    }
}