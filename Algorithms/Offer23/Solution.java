// Approach 1: Binary search
class Solution {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int lo = 1;
        int hi = length - 1;
        while (lo != hi)
        {
            int mid = (lo + hi) / 2;
            int count = 0;
            for (int i = 0; i < length; i++)
                if ((lo <= nums[i]) && (nums[i] <= mid))
                    count++;
            if (mid - lo + 1 < count)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}

// Approach 2: Floyd cycle detection algorithm
class Solution {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
