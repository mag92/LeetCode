// 1- Add an edge
// 2- Run DFS to check if the edge created a cycle
// 2.1- if a cycle created, return last added edge
// 2.1- if not, keep adding edges

class Solution {
    private boolean[] marked;
    private boolean hasCycle;
    private LinkedList<Integer>[] adj;

    
    public int[] findRedundantConnection(int[][] edges) {
        
        int maxV = edges.length;
        //for(int i = 0; i < edges.length; i++) { 
        //    if (edges[i][0] > maxV) maxV = edges[i][0];
        //}
        
        
        marked = new boolean[edges.length+1];
        // build graph
        adj = new LinkedList[edges.length+1];
        for(int i = 1; i <= edges.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        // add edges
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            
            // everytime new edge added, dfs
            // main dfs:
            for(int k = 0; k < marked.length; k++) {
                marked[k] = false;
            }
            
            for(int j = 1; j <= maxV; j++) {
                if (!marked[j]) dfs(j, j);
                
            
                if (hasCycle)
                    //return cycle;
                    return new int[]{edge[0], edge[1]};
            }
            
        }
        return new int[5];
    }
    
    private void dfs(int to, int from) {
        marked[to] = true;
        for(int n : adj[to]) {
            if (!marked[n]) dfs(n, to);
            
            else if (n != from) { // visited before
                hasCycle = true;
                
                }
            
            
        }
 
            
    }
}
