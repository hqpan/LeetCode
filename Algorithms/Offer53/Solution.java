// Solution 1: ½£Ö¸ Offer 53-I
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int first = getFirst(nums, target);
        int last = getLast(nums, target);
        if (first == -1 || last == -1)
            return 0;
        return  last - first + 1;
    }

    public int getFirst(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else {
                if (mid == 0 || (nums[mid - 1] != target))
                    return mid;
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int getLast(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else {
                if (mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                lo = mid + 1;
            }
        }
        return -1;
    }
}

// Solution 2: ½£Ö¸ Offer 53-II
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == mid) {
                lo = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == mid - 1)
                    return mid;
                hi = mid - 1;
            }
        }
        return nums.length;
    }
}