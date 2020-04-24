/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// ½£Ö¸ Offer 32-III
class Solution {
    public int[] levelOrder(TreeNode root) {        
        if (root == null)
            return new int[] {};
        ArrayList<Integer> nums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            nums.add(temp.val);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++)
            ans[i] = nums.get(i);
        return ans;
    }
}

// ½£Ö¸ Offer 32-III
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {            
            List<Integer> row = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();
                row.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            ans.add(row);      
        }
        return ans;
    }
}

// ½£Ö¸ Offer 32-III
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();
                row.add(temp.val);                    
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            if ((ans.size() & 1) == 1)
                Collections.reverse(row);
            ans.add(row);
        }
        return ans;
    }
}