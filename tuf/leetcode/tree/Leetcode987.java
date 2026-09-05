package leetcode.tree;

public class Leetcode987 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<int[]>> colMap = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<int[]> columnList: colMap.values()){
            columnList.sort((a,b)->{
                int rowCompare = Integer.compare(a[0], b[0]);
                if(rowCompare!=0) return rowCompare;
                return Integer.compare(a[1], b[1]);
            });
            List<Integer> colValues = new ArrayList<>();
            for(int[] pair: columnList){
                colValues.add(pair[1]);
            }
            ans.add(colValues);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col){
        if(node==null) return;
        colMap.putIfAbsent(col, new ArrayList<>());
        colMap.get(col).add(new int[]{row, node.val});
        dfs(node.left, row+1, col-1);
        dfs(node.right, row+1, col+1);
    }
}
