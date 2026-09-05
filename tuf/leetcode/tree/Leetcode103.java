package leetcode.tree;

public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean startLeft = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(size, -1));
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                int index = startLeft ? i : size-i-1;
                level.set(index, curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            ans.add(level);
            startLeft = !startLeft;
        }
        return ans;
    }
}

