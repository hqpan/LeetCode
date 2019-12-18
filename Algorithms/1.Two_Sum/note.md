[TOC]


# 1. LeetCode 1
- 暴力求解：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 哈希表：两次循环：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 哈希表：一次循环：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

# 2. 暴力求解
- 解题思路：二重循环遍历所有数值组合；
- 难点：内循环中的计数变量应从$j=i+1$开始，而非$j=0$，以减小计算开销；

```java
// Approach 1: 暴力求解算法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++)	// j=i+1, 而非j=0
                if (nums[i] + nums[j] == target)
                    return new int[] {i, j};
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

# 3. 哈希表：两次循环
- 解题思路：
  - 第一次循环将索引添加到哈希表中；
  - 第二次循环遍历数组中的所有元素，判断哈希表中是否存在满足要求的另一个元素；

```java
// Approach 2: 哈希表：两次循环
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> st = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            st.put(nums[i], i);
        for (int i = 0; i < nums.length; i++)
            if (st.containsKey(target - nums[i]) && st.get(target - nums[i]) != i)
                return new int[] {i, st.get(target - nums[i])}; 
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

# 4. 哈希表：一次循环
- 解题思路：一次循环将索引添加到哈希表中，每次添加元素的同时检测哈希表中是否存在满足要求的另一个元素；
- 难点：处理键值碰撞问题，E.g. [3, 3], 6；
  - 若两个元素数值相同，则以此为键值存入哈希表中，后者的值将覆盖前者的值；
- 解决方案：为避免逻辑错误，应先检测哈希表中是否存在满足要求的另一个元素，后将该值添加到哈希表中；

```java
// Approach 3: 哈希表：一次循环
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> st = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            // st.put(nums[i], i);      // incorrect
            if (st.containsKey(target - nums[i]) && st.get(target - nums[i]) != i)
                return new int[] {i, st.get(target - nums[i])};
            st.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
```
