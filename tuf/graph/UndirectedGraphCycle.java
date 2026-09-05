/* USING DFS
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, -1, adj, visited)){
                return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]) {
                if( dfs(neighbour, node, adj, visited)) return true;
            }
            
            else if(neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
}
*/


//USING BFS
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }
    
    private boolean bfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        //store {node, parent}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, -1});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curr = current[0];
            int parent = current[1];
            for(int neighbour:adj.get(curr)){
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new int[]{neighbour, curr});
                }
                else if(neighbour!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
