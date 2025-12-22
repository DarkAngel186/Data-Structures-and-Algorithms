import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a solution for GFG problem BFS:
 * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 */
class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
       
        while(!queue.isEmpty()) {
            
            int src = queue.remove();
            ans.add(src);
            
            ArrayList<Integer> dests = adj.get(src);
            
            for(int dest: dests) {
                
                if(!vis[dest]) {
                    
                    queue.add(dest);
                    vis[dest] = true;
                }
            }
        }
        
        return ans;
    }
}