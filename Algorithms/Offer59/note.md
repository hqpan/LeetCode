[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 239 & 剑指 Offer 59-I

## 1.1 复杂度分析

- 双端队列：求解滑动窗口最大值；
  
  - 时间复杂度：$O(n)$；
  
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 59-I；

## 1.2 双端队列

- 解题思路：求解滑动窗口最大值；
- 分析：
  - 将双端队列中不属于当前滑动窗口的值删除；
  - 双端队列中剩余的值均属于当前滑动窗口，若双端队列中的某些值小于当前值，则其必不可能为最大值，直接删除即可；
- 实现：
  - 遍历原始数组，依次将各元素的索引添加至双端队列的尾部；
  - 若双端队列的首部元素索引不位于滑动窗口内，则从双端队列首部删除该索引；
  - 依次将双端队列尾部小于当前值的元素对应的索引删除；
  - 双端队列首部元素索引即为所求；

```java
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
```

# 2. 剑指 Offer 59-II

## 2.1 复杂度分析

- 双端队列：
  - 时间复杂度：$O(1)$；
  - 空间复杂度：$O(n)$；

## 2.2 双端队列

- 解题思路：
  - 创建2个双端队列：
    - `nums`：存放所有元素；
    - `max`：存放当前最大元素；
  - 维护`max`：
    - 若弹出元素与`max`头部元素相等，则将`max`中的该值弹出；
    - 若有元素添加至双端队列，则将`max`中小于当前元素的值删除；
- 难点：插入元素时至多发生$n$次删除操作，每个元素至多被删除1次，因此平均时间复杂度仍为$O(1)$；

```java
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
```

# 3. Summary

- 参见 LeetCode 239、剑指 Offer 59-II 解题思路；
- 注意：对于`peek()`、`poll`等操作，需要预先检测集合是否为空；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.