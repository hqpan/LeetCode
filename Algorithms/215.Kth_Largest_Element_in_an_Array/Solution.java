// Approach 1: Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null ||nums.length == 0)
            throw new RuntimeException("Invalid input!");
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}

// Approach 2: Partition
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null ||nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int lo = 0; 
        int hi = nums.length - 1;
        int index = partition(nums, lo, hi);
        while (index != nums.length - k ) {
            if (index < nums.length - k) {
                lo = index + 1;
                index = partition(nums, lo, hi);
            } else {
                hi = index - 1;
                index = partition(nums, lo, hi);
            }
        }
        return nums[index];
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int base = nums[lo];
        while (true) {
            while (i < hi && nums[++i] < base)
                if (i == hi)
                    break;
            while (j > lo && nums[--j] > base)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}