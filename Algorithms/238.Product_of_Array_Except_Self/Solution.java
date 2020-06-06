class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2)
            return new int[0];
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++)
            res[i] = 1;
        int product = 1;
        for (int i = 0; i < res.length - 1; i++) {
            product *= nums[i];
            res[i + 1] *= product;
        }
        product = 1;
        for (int i = res.length - 1; i > 0; i--) {
            product *= nums[i];
            res[i - 1] *= product;
        }
        return res;
    }
}