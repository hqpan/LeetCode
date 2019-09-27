class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        int xor1 = 0;
        int xor0 = 0;
        // calculate the XOR of nums[] and 1-n
        for(int i = 1; i <= nums.length; i++)
        {
            xor ^= i;
        }
        for(int i: nums)
        {
            xor ^= i;
        }
        // calculate the rightMostBit
        int rightMostBit = xor & (~(xor-1));
        // calculate the XOR1 and XOR0
        for(int i = 0; i <= nums.length; i++)
        {
            if((rightMostBit & i) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        for(int i: nums)
        {
            if((rightMostBit & i) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        // find the missing number and duplicated number
        for(int i: nums)
        {
            if((xor1 ^ i) == 0)
                return new int[]{xor1, xor0};
        }
        return new int[]{xor0, xor1};
    }
}
