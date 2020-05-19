class Solution {
    private static int[] aux;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;        
        aux = new int[nums.length];
        return sort(nums, 0, nums.length - 1);
    }

    public static int sort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return 0;
        int mid = lo + (hi - lo) / 2;
        int countL = sort(nums, lo, mid);
        int countR = sort(nums, mid + 1, hi);
        return countL + countR + merge(nums, lo, mid, hi);
    }

    public static int merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = nums[i];
        int left = lo;
        int right = mid + 1;
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (left > mid)
                nums[i] = aux[right++];
            else if (right > hi) {
                nums[i] = aux[left++];
                count += right - mid - 1;
            }
            else if (aux[left] > aux[right])
                nums[i] = aux[right++];
            else {
                nums[i] = aux[left++];
                count += right - mid - 1;
            }                      
        }
        return count;
    }
}