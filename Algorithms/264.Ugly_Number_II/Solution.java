// Approach 1：动态规划
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

// Approach 2：创建三个数组，生成所有“丑数”（大于n个）
class Solution {
    public static int nthUglyNumber(int n) {
        long[] arr2 = new  long[n];
        long[] arr3 = new  long[n];
        long[] arr5 = new  long[n];
        long[] uglyNum = new  long[n];

        arr2[0] = 1;
        arr3[0] = 1;
        arr5[0] = 1;
        uglyNum[0] = 1;

        for(int i = 1; i < n; i++)
        {
            arr2[i] = uglyNum[i-1] * 2;
            arr3[i] = uglyNum[i-1] * 3;
            arr5[i] = uglyNum[i-1] * 5;

            long min = 2147483647;
            // System.out.println(arr2[i] + " " + arr3[i] + " " + arr5[i]);
            for(int j = 1; j <= i; j++)
            {
                if((arr2[j] > uglyNum[i-1]) && (arr2[j] < min))
                    min = arr2[j];
                if((arr3[j] > uglyNum[i-1]) && (arr3[j] < min))
                    min = arr3[j];
                if((arr5[j] > uglyNum[i-1]) && (arr5[j] < min))
                    min = arr5[j];

                // test
                if(arr2[j] == 1079803904)
                    System.out.println("arr2: " + j);
                if(arr3[j] == 1079803904)
                    System.out.println("arr3: " + j);

            }
            uglyNum[i] = min;
        }
        return (int) uglyNum[n-1];
    }
}
