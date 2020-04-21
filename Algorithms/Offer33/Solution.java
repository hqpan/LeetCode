// Approach 1: Recursion, divide and conquer
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return true;
        return detect(postorder, 0, postorder.length - 1);
    }

    public boolean detect(int[] postorder, int lo, int hi) {
        if (lo >= hi)
            return true;
        int index = lo;
        while (postorder[index] < postorder[hi])
            index++;
        int tempIndex = index;
        while (postorder[index] > postorder[hi])
            index++;
        return index == hi && detect(postorder, lo, tempIndex - 1) && detect(postorder, tempIndex, hi - 1);
    }
}