import java.util.ArrayList;

/**
 * This is a solution for GFG problem DFS:
 * https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 */
class DFS {
    
    boolean[] vis;
    ArrayList<Integer> ans;

    private void solve(ArrayList<ArrayList<Integer>> adj, int src) {
        
        ans.add(src);
        vis[src] = true;
        
        ArrayList<Integer> dests = adj.get(src);
        
        for(int dest : dests) {
            
            if(!vis[dest]) solve(adj, dest);
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        vis = new boolean[adj.size()];
        ans = new ArrayList<>();
        
        solve(adj, 0);
        
        return ans;
    }
}
