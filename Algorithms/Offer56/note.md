[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 136

## 1.1 复杂度分析

- 暴力求解：==无需复习==
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；
- 排序：==无需复习==
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(logn)$；
- 散列表：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 异或运算：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；

## 1.2 异或运算

- 解题思路：异或运算的性质；
  - $a\oplus a=0$；
    - 相同值经异或运算得0；
    - 恰对应于每个相同的元素出现偶数次；
  - $0\oplus a=a$；
    - 任何值与0进行异或运算，均不改变该值；
  - 异或运算满足交换律与结合律：$a\oplus b\oplus a=(a\oplus a)\oplus b=0\oplus b =b$；

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num; 
        }
        return res;
    }
}
```

# 2. LeetCode 137 & 剑指 Offer 56-II

## 2.1 复杂度分析

- 排序：==无需复习==
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(logn)$；
- 散列表：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 位运算：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 相同的题：剑指 Offer 56-II；

## 2.2 位运算

- 解题思路：
  - `int`为32位，可创建一个32位数组；
  - 将原始数据使用二进制的形式表示，累加每一个 bit 上的值；
  - 由题意可知，仅有1个数字出现1次，其余数字均出现3次，因此将各个 bit 的累加值对3取余；
  - 将取余后的各个 bit 上的值仍视为一个二进制数，即为所求；
- 难点：将取余后的数组还原为一个二进制数时，需要先将`res`左移，再累加；
  - `res = res << 1;`；
  - `res += (bits[i] % 3); `；

```java
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int[] bits = new int[32];
        for (int num : nums) {
            for (int j = 31; j >= 0; j--) {
                bits[j] += num & 1;
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            res = res << 1;
            res += (bits[i] % 3);            
        }
        return res;
    }
}
```

# 3. LeetCode 260 & 剑指 Offer 56-I

## 3.1 复杂度分析

- 分组异或：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 相同的题：剑指 Offer 56-I；

## 3.2 分组异或

- 解题思路：
  - 不妨设仅出现1次的数分别为 A、B，对所有元素执行异或运算结果为 C，则有$A\oplus B=C$；
  - 在 LeetCode 136 的基础上，LeetCode 260 中含有2个仅出现1次的数，若能将 A、B 分到2个子数组中，即可使用异或运算求解；
  - 分组依据：以 C 的二进制表示形式中，某个不为0的 bit 作为划分依据；
    - 将原始数据中所有的元素分为2组；
    - 由$A\oplus B=C$可知，A、B 在该比特位上不同，即 A、B 必被划分至不同子数组中；
    - 剩余的成对数值将被成对划分至某个子数组中；

```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input!");
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        int mask = getMask(ans);
        int[] res = new int[2]; 
        for (int num : nums) {
            if ((num & mask) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }

    public int getMask(int ans) {
        int count = 0;
        while ((ans & 1) == 0) {
            ans = ans >>> 1;
            count++;
        }
        return 1 << count;
    }
}
```

# 4. Summary

- 参见 LeetCode 136、137、260 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.