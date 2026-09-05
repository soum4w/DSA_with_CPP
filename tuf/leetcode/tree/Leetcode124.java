package leetcode.tree;
public class Leetcode124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    private int solve(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));
        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}