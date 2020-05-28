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
class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        int mask = getMask(ans);
        int[] res = new int[2]; 
        for (int num : nums) {
            if ((num & mask) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }

    public int getMask(int ans) {
        int count = 0;
        while ((ans & 1) == 0) {
            ans = ans >>> 1;
            count++;
        }
        return 1 << count;
    }
}