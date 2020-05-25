// Solution of LeetCode 136
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num; 
        }
        return res;
    }
}

// Solution of LeetCode 137 & ½£Ö¸ Offer 56-II
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int[] bits = new int[32];
        for (int num : nums) {
            for (int j = 31; j >= 0; j--) {
                bits[j] += num & 1;
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            res = res << 1;
            res += (bits[i] % 3);            
        }
        return res;
    }
}

// Solution of LeetCode 260 & ½£Ö¸ Offer 56-I
