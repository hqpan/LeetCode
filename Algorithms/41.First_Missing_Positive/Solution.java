// label itself, O(n), O(1)
// ********************************************************** 
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;  
        int exist1 = 0;      
        for(int i: nums)
        {
            if((i == 1))
                exist1 = 1;
        }
        if(exist1 == 0)
            return 1;

        for(int i = 0; i < length; i++)
        {
            if(nums[i] <= 0)
                nums[i] = 1;
        }
        
        for(int i = 0; i < length; i++)
        {
            int currentValue = Math.abs(nums[i]);
            if(currentValue <= length)
                nums[currentValue-1] = -Math.abs(nums[currentValue-1]);
        }

        for(int i = 0; i < length; i++)
        {
            if(nums[i] > 0)
                return i+1; 
        }
        return length+1;
    }
}

// create an auxiliary array, O(n), O(n)
// ********************************************************** 
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] labels = new int[length];
        for(int i: nums)
        {
            if((i > 0) && (i <= length))
                labels[i - 1] = 1;
        }
        for(int i = 0; i < length; i++)
        {
            if(labels[i] == 0)
                return i + 1;
        }
        return length + 1;
    }
}


// quick sort, O(nlogn), O(n)
// **********************************************************
quick sort, O(nlogn), O(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missingNum = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] <= 0)
                continue;
            else if((nums[i] != missingNum) && (nums[i] > missingNum))
                return missingNum;
            else if((nums[i] == missingNum) && ((i == 0) || (nums[i] != nums[i-1])))
                missingNum++;
        }
        return missingNum;
    }
}
