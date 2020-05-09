class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {  
            currSum = currSum <= 0 ? num : num + currSum;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}