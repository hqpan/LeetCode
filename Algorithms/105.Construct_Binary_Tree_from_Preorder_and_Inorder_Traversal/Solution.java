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
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> st = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++)
            st.put(inorder[i], i);
        return buildTree(0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int preStart, int inStart, int inEnd) { 
        if ((preStart > preorder.length) || (inStart > inEnd))
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = st.get(root.val);
        root.left = buildTree(preStart + 1, inStart, index - 1);
        root.right = buildTree(preStart + index - inStart + 1, index + 1, inEnd);
        return root;
    }
}