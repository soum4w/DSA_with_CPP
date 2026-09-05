package leetcode.tree;

public class Leetcode572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root.val == subRoot.val && isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode p, TreeNode q){
        if(p==null || q==null) return p==q;
        boolean leftSame = isIdentical(p.left, q.left);
        boolean rightSame = isIdentical(p.right, q.right);
        return leftSame && rightSame && p.val==q.val;
    }
}