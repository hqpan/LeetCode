class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0)
            return 0;
        String tempStr = str.trim();
        int index = 0;
        int sign = 1;
        if (tempStr.charAt(0) == '+')
            index++;
        else if (tempStr.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        long res = 0;
        while (index < tempStr.length() && '0' <= tempStr.charAt(index) && tempStr.charAt(index) <= '9') {
            int bit = tempStr.charAt(index) - '0';
            res = 10 * res + bit;
            index++;
            if (res > Integer.MAX_VALUE)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign == 1 ? (int) res : - (int) res;
    }
} 