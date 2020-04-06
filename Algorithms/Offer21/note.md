[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. 剑指 Offer 21
- 考察内容：
  - 双指针；
  
  - 代码鲁棒性设计：
    - 在2个 while 循环**中**需要考虑2个指针的先后关系；
      - 防止访问数组越界，E.g. [1, 3, 5]；
    - 在2个 while 循环**后**需要考虑2个指针的先后关系；
      - 判断是否需要交换元素；
- 相似问题：策略模式，将判断数组中元素是否属于某一类的代码封装为一个函数，从主函数中解耦，即可解决多个相似问题，实现代码复用，E.g. 判断数组中的某个元素是否为奇数；
  - 将数组中的负数放在前半部分，非负数放在后半部分；
  - 将数组中能被3整除的数放在前半部分，将不能被整除的数放在后半部分；
- 辅助数组：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 双指针：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；



# 2. 辅助数组
- 解题思路：
  - 建立一个与原始数组等长的辅助数组；
  - 定义两个变量`head`、`behind`，分别指向辅助数组的首部和尾部；
  - 遍历原始数组，若检测到奇数，则将其放置于`head`指向的位置，否则放置于`behind`指向的位置；
  - 缺点：空间复杂度高；

```java
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
```



# 3. 双指针

- 解题思路：
  - 定义两个变量`ahead`、`behind`，分别指向数组的首部和尾部；
  - 不断向后移动`ahead`，直至检测到偶数；
  - 不断向前移动`behind`，直至检测到奇数；
  - 交换2个变量指向的元素；
  - 重复上述步骤，直至2个变量的相对位置为`behind<ahead`；

```java
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
```





# 4. Summary

## 4.1 Java 语法

- `==`、`!=`的优先级高于`&`，需要加括号；



## 4.2 算法优化

- 计算性能优化：判断数值奇偶性应使用位运算，计算速度优于取余运算；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.