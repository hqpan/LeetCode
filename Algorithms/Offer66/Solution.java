class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2)
            return new int[0];
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++)
            res[i] = 1;
        int product = 1;
        for (int i = 0; i < a.length - 1; i++) {
            product *= a[i];
            res[i + 1] *= product;
        }
        product = 1;
        for (int i = a.length - 1; i > 0; i--) {
            product *= a[i];
            res[i - 1] *= product;
        }
        return res;
    }
}