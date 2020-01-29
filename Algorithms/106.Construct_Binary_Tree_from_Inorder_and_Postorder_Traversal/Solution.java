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
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> st = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++)
            st.put(inorder[i], i);
        return buildTree(0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode buildTree(int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd || 0 > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = st.get(root.val);
        root.left = buildTree(inStart, index - 1, postEnd - inEnd + index - 1);
        root.right = buildTree(index + 1, inEnd, postEnd - 1);
        return root;
    }
}