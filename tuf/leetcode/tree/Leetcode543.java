package leetcode.tree;

public class Leetcode543 {
    int ans =0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    private int height(TreeNode root){
        if(root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        ans = Math.max(ans, leftHeight+rightHeight);
        return 1+ Math.max(leftHeight, rightHeight);
    }
}