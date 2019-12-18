// Approach 1: 暴力求解算法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++)	// j=i+1, 而非j=0
                if (nums[i] + nums[j] == target)
                    return new int[] {i, j};
        throw new IllegalArgumentException("No two sum solution");
    }
}

// Approach 2: 哈希表：两次循环
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> st = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            st.put(nums[i], i);
        for (int i = 0; i < nums.length; i++)
            if (st.containsKey(target - nums[i]) && st.get(target - nums[i]) != i)
                return new int[] {i, st.get(target - nums[i])}; 
        throw new IllegalArgumentException("No two sum solution");
    }
}

// Approach 3: 哈希表：一次循环
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> st = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            // st.put(nums[i], i);      // incorrect
            if (st.containsKey(target - nums[i]) && st.get(target - nums[i]) != i)
                return new int[] {i, st.get(target - nums[i])};
            st.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}

