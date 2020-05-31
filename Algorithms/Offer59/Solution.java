// Solution of LeetCode 239 & ½£Ö¸ Offer 59-I
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[] {};  
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = 1 - k; i < nums.length; i++, j++) {            
            if (!deque.isEmpty() && i - deque.peekFirst() >= k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.addLast(i);
            if (j >= 0)
                res[j] = nums[deque.peekFirst()];
        }
        return res;
    }
}

// ½£Ö¸ Offer 59-II
class MaxQueue {
    Deque<Integer> nums;
    Deque<Integer> max;

    public MaxQueue() {
        nums = new LinkedList<>();
        max = new LinkedList<>();
    }
    
    public int max_value() {
        return max.isEmpty() ? -1 : max.peekFirst();
    }
    
    public void push_back(int value) {
        while (!max.isEmpty() && max.peekLast() < value)
            max.pollLast();
        nums.addLast(value);
        max.addLast(value);
    }
    
    public int pop_front() {
        if (nums.isEmpty())
            return -1;
        int res = nums.pollFirst();
        if (res == max_value())
            max.pollFirst();
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */