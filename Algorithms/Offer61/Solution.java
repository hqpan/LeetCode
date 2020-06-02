class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        int gap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            if (nums[i] == nums[i + 1])
                return false;
            gap += nums[i + 1] - nums[i] - 1;
        }
        return zero >= gap ? true : false;
    }
}