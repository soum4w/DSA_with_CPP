package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        //Recursive approach :

//        List<Integer> ans = new ArrayList<>();
//        preorder(root, ans);
//        return ans;
//    }
//
//    private void preorder(TreeNode root, List<Integer> ans){
//        if(root == null ) return;
//        ans.add(root.val);
//        preorder(root.left, ans);
//        preorder(root.right, ans);
//    }

        //Iterative approach using Stack

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return ans;
    }
}