// 新建标记数组
// class Solution {
//     public int missingNumber(int[] nums) {
//         int length = nums.length;
//         int[] aux = new int[length+1];
//         int index;
//         for(int i=0; i<length; i++)
//         {
//             index = nums[i]; 
//             aux[index] = 1;
//         }
        
//         for(int i=0; i<length+1; i++)
//         {
//             if(aux[i] == 0)
//                 return i;
//         }
//         return -1;
//     }
// }

// 高斯求和
// class Solution {
//     public int missingNumber(int[] nums) {
//         int length = nums.length;
//         int sum = length*(length+1)/2;
//         for(int i=0; i<length; i++)
//         {
//             sum -= nums[i];
//         }
//         return sum;
//     }
// }

// 位运算
class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int ans = length;
        for(int i=0; i<length; i++)
        {
            ans = ans^i^nums[i];
        }
        return ans;
    }
}

// 哈希表未处理

