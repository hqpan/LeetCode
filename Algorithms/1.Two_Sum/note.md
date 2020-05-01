[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 1

## 1.1 复杂度分析

- 暴力求解：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 哈希表：两次循环：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 哈希表：一次循环：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相似的题：LeetCode 15；

## 1.2 暴力求解
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

## 1.3 哈希表：两次循环
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

## 1.4 哈希表：一次循环
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

# 2. LeetCode 15

## 2.1 复杂度分析

- 二重循环+双指针：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；

## 2.2 二重循环+双指针

- 解题思路：
  - 3数之和：`a+b+c=0`；
  - 等价于2数之和：`a=-(b+c)`；
  - 为避免求得重复3元组，先将数组排序；
  - 外循环：遍历数组，确定2数之和，即`a`值；
  - 内循环：
    - 若`a`值当前索引为`i`，则双指针分别指向`i+1`和`nums.length - 1`；
    - 若`nums[i]>0`，则3数之和必大于0，继续遍历仍无结果，终止外循环；
    - 若3数之和小于0，则右移左指针；
    - 若3数之和大于0，则左移右指针；
    - 若3数之和等于0，则将3元组加入`List`；
  - ==注意==：为避免求得重复3元组，除了需要将数组排序外，还需在外循环、内循环中去重；
    - 即在二重循环中，若a、b、c值与此前a、b、c值相同，则可能求得重复3元组；
    - 跳过当前重复值即可；
    - LeetCode 15 中，未使用哈希表，因为使用哈希表可能求得重复3元组；

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums == null)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return list;
    }
}
```

# 3. Summary

## 3.1 Grammar

- `java.util.Arrays`：
  - `public static <T> List<T> asList(T... a)`：将多个元素写入一个`List`中并返回该`List`；
  - E.g. `List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");`；

## 3.2 算法设计

- 参见 LeetCode 1，哈希表一次循环解题思路；
- 参见 LeetCode 15，二重循环+双指针解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.