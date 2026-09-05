package tree;

public class topViewOfBT {}

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public List<Integer> topView(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        if(root==null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            if(!map.containsKey(curr.hd)) map.put(curr.hd, curr.node.data);
            if(curr.node.left!=null) queue.offer(new Pair(curr.node.left, curr.hd-1));
            if(curr.node.right!=null) queue.offer(new Pair(curr.node.right, curr.hd+1));
        }
        for(int value:map.values()) ans.add(value);
        return ans;
    }
}