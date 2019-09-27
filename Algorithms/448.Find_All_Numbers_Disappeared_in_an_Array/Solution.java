class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        ArrayList array = new ArrayList();
	// mark the array
        for(int i = 0; i < length; i++)
        {
            int index = Math.abs(nums[i]);
            int label = nums[index - 1];
            if(label > 0)
                nums[index - 1] = -label;
        }
	// find the missing numbers
        for(int i = 0; i < length; i++)
        {
            if(nums[i] > 0)
                array.add(i + 1);
        }
        return array;
    }
}

