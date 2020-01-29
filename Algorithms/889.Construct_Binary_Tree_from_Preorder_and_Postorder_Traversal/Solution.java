/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int[] pre;
    int[] post;
    HashMap<Integer, Integer> st = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        for (int i = 0; i < post.length; i++)
            st.put(post[i], i);
        return constructFromPrePost(0, pre.length - 1, 0);
    }

    public TreeNode constructFromPrePost(int preStart, int preEnd, int postStart) {
        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd)
            return root;       
        int index = st.get(pre[preStart + 1]) - postStart;
        root.left = constructFromPrePost(preStart + 1, preStart + index + 1, postStart);
        root.right = constructFromPrePost(preStart + index + 2, preEnd, postStart + index + 1);
        return root;
    }
}