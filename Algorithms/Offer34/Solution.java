class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> row = new LinkedList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        detect(root, sum);
        return res;
    }
    
    public void detect(TreeNode root, int sum) {
        if (root == null)
            return;
        row.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0)
            res.add(new LinkedList(row));
        detect(root.left, sum);
        detect(root.right, sum);
        row.pollLast();
    }
}