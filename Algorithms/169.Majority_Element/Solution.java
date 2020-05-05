// Approach 1: Partition
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid array!");
        int lo = 0;
        int mid = nums.length >> 1;
        int hi = nums.length - 1;
        int index = partition(nums, lo, hi);
        while (index != mid) {
            if (index > mid) {
                hi = index - 1;
                index = partition(nums, lo, hi);
            } else {
                lo = index + 1;
                index = partition(nums, lo, hi);
            }
        }
        return nums[mid];
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int base = nums[lo];
        while (true) {
            while (i < hi && nums[++i] < base)
                if (i == hi)
                    break;
            while (j > lo && nums[--j] > base)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    public void exch(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

// Approach 2: Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid array!");
        int res = nums[0];
        int votes = 0;
        for (int num : nums) {
            if (votes == 0)
                res = num;
            votes += res == num ? 1 : -1;
        }
        return res;
    }
}