package tree;

public class BoundryTraversal {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

    public List<Integer> boundary(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        leftWall(root, ans);
        leafs(root, ans);
        rightWall(root, ans);
        return ans;
    }

    private void leftWall(TreeNode root, List<Integer> ans){
        TreeNode curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr = curr.right;
        }
    }

    private void leafs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        leafs(root.left, ans);
        leafs(root.right, ans);
    }

    private void rightWall(TreeNode root, List<Integer> ans){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root.right;
        while(curr!=null){
            if(!isLeaf(curr)) stack.push(curr);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop().data);
        }
    }

    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

}