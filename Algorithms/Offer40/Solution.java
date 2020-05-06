// Approach 1: Heap
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0)
            throw new RuntimeException("Invalid input!");
        PriorityQueue<Integer> heap = new PriorityQueue<>((val1, val2) -> val2 - val1);
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        int[] res = new int[k];
        for (int i = heap.size() - 1; i >= 0; i--)
            res[i] = heap.poll();
        return res;
    }
}

// Approach 2: Partition
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0)
            throw new RuntimeException("Invalid input!");
        if (k == 0)
            return new int[] {};
        int lo = 0;
        int hi = arr.length - 1;
        int index = partition(arr, lo, hi);
        while (index != k - 1) {
            if (index < k - 1) {
                lo = index + 1;
                index = partition(arr, lo, hi);
            } else {
                hi = index - 1;
                index = partition(arr, lo, hi);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    public int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int base = arr[lo];
        while (true) {
            while (i < hi && arr[++i] < base)
                if (i == hi)
                    break;
            while (j > lo && arr[--j] > base)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}