// Approach 1: Auxiliary array
class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null)
            throw new RuntimeException("This is an null reference!");
        if (nums.length == 0)
            return nums;
        int[] aux = new int[nums.length];
        int head = 0;
        int tail = nums.length - 1;
        for (int number: nums) {
            if ((number & 1) == 1)
                aux[head++] = number;
            else
                aux[tail--] = number;
        }
        return aux;
    }
}

// Approach 2: two points
class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null)
            throw new RuntimeException("This is an null reference!");
        if (nums.length == 0)
            return nums;
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            while (head < tail && (nums[head] & 1) == 1) {
                ++head;
            }
            while (head < tail && (nums[tail] & 1) == 0)
                --tail;
            if (head < tail) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
        }
        return nums;
    }
}