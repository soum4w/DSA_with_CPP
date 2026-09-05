package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Leetcode145 {
/*
    //Recursive Approach:

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            postOrder(root, ans);
            return ans;
        }

        private void postOrder(TreeNode root, List<Integer> ans){
            if(root == null ) return;
            postOrder(root.left, ans);
            postOrder(root.right, ans);
            ans.add(root.val);
        }
    }
*/

//Iterative approach (using 2 stacks):

//        public List<Integer> postorderTraversal(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//            Deque<TreeNode> stack1 = new ArrayDeque<>();
//            Deque<TreeNode> stack2 = new ArrayDeque<>();
//            if(root==null) return ans;
//            stack1.push(root);
//            while(!stack1.isEmpty()){
//                TreeNode node = stack1.pop();
//                stack2.push(node);
//                if(node.left!=null) stack1.push(node.left);
//                if(node.right!=null) stack1.push(node.right);
//            }
//            while(!stack2.isEmpty()){
//                ans.add(stack2.pop().val);
//            }
//            return ans;
//        }
//    }

// Using single stack iterative approach :

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.peek();
                if(node.right!=null && lastVisited!=node.right){
                    curr = node.right;
                } else {
                    ans.add(node.val);
                    lastVisited = stack.pop();
                }
            }
        }
        return ans;
    }
}