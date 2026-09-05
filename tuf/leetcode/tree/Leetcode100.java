package leetcode.tree;

public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return p==q;
        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);
        return leftSame && rightSame && p.val==q.val;
    }
}