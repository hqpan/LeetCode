// Approach 1: 逐位移动mask
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)    // 运算优先级
                count++;
            mask = mask << 1;
        }
        return count;
    }
}

// Approach 2: 逐位移动n
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {    // 终止条件为 n!=0，无需设置为右移32次
            if ((n & 1) == 1)
                count++;
            n = n >>> 1;
        }
        return count;
    }
}

// Approach 3: 逐次取最右侧的1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {    // 终止条件为 n!=0，无需设置为右移32次
            count++;
            n &= n - 1;
        }
        return count;
    }
}