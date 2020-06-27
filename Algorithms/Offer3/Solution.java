// Approach 1: HashSet
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            if (!set.add(nums[i]))
                return nums[i];
        return -1;
    }
}

// Approach 2: negative number
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index < 0)
                index += nums.length;
            if (nums[index] < 0)
                return index;
            nums[index] = nums[index] - nums.length;
        }
        return -1;
    }
}
