// Approach 1: ��λ�ƶ�mask
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)    // �������ȼ�
                count++;
            mask = mask << 1;
        }
        return count;
    }
}

// Approach 2: ��λ�ƶ�n
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {    // ��ֹ����Ϊ n!=0����������Ϊ����32��
            if ((n & 1) == 1)
                count++;
            n = n >>> 1;
        }
        return count;
    }
}

// Approach 3: ���ȡ���Ҳ��1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {    // ��ֹ����Ϊ n!=0����������Ϊ����32��
            count++;
            n &= n - 1;
        }
        return count;
    }
}