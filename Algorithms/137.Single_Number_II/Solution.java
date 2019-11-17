// Approach 1: 统计每 1 bit 上数值1出现的次数
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++)
        {
            int sum = 0;
            for (int number : nums)
            {
                if (((number >> i) & 1) != 0)
                    sum++;
            }
            sum %= 3;
            if (sum != 0)
                ans |= (sum << i);
        }
        return ans;
    }
}

// Approach 2: 三进制无进位加法器——使用 mask 处理溢出
class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        int mask;
        for (int number : nums)
        {
            two = two | (one & number);
            one = one ^ number;
            mask = ~(one & two);
            two &= mask;
            one &= mask;
        }
        return one;
    }
}

// Approach 3: 三进制无进位加法器——自动处理溢出
class Solution {
    public int singleNumber(int[] nums) {        
        int two = 0;
        int one = 0;
        for (int number : nums)
        {            
            one = (~two) & (one ^ number);			// 分步计算各个bit
            two = (~one) & (two ^ number);
            // int tempTwo = (two ^ one) & (~(one ^ number));	// 同时计算各个bit
            // int tempOne = (~two) & (one ^ number);
            // two = tempTwo;
            // one = tempOne;
        }
        return one;
    }
}
