// Approach 1: Recursion
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum); 
    }

    private int count(TreeNode node, int sum)
    {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0) + count(node.left, sum - node.val) + count(node.right, sum - node.val);
    }
}

// Approach 2: Iteration
class Solution {
    public int pathSum(TreeNode root, int sum) {
        int ans = 0;
        if (root == null)
            return ans;
        Stack<TreeNode> outer = new Stack<>();
        Stack<TreeNode> inner = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        outer.push(root);
        while (!outer.isEmpty())
        {
            TreeNode node = outer.pop();
            inner.push(node);
            nums.push(sum);
            while (!inner.isEmpty())
            {
                TreeNode temp = inner.pop();
                int currSum = nums.pop() - temp.val;
                if (currSum == 0)
                    ans++;
                if (temp.left != null)
                {
                    inner.push(temp.left);
                    nums.push(currSum);
                }
                if (temp.right != null)
                {
                    inner.push(temp.right);
                    nums.push(currSum);
                }
            }
            if (node.left != null)
                outer.push(node.left);
            if (node.right != null)
                outer.push(node.right);
        }
        return ans;
    }
}

