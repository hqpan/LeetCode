class Solution {
    public static int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int nextNum2 = ans[index2] * 2;
        int nextNum3 = ans[index2] * 3;
        int nextNum5 = ans[index2] * 5;

        for(int i = 1; i < n; i++)
        {
            ans[i] = Math.min(nextNum2, Math.min(nextNum3, nextNum5));

            if(ans[i] == nextNum2)
                nextNum2 = ans[++index2] * 2;
            if(ans[i] == nextNum3)
                nextNum3 = ans[++index3] * 3;
            if(ans[i] == nextNum5)
                nextNum5 = ans[++index5] * 5;
        }
        return ans[n-1];
    }
}