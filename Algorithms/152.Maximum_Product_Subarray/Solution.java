class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num, num * max);
            min = Math.min(num, num * min);
            res = Math.max(max, res);
        }
        return res;
    }
}