import java.util.ArrayList;

/**
 * This is a solution for GFG problem, Undirected Graph Cycle:
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 */
public class DetectCycleInUndirectedGraph {
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis) {
        
        if(vis[src]) return true;
        
        ArrayList<Integer> dests = graph.get(src);
        
        vis[src] = true;
        
        for(int dest : dests) {
            
            if(
                dfs(graph, dest, vis)) return true;
        }
        
        vis[src] = false;
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < V; i++) {
            
            System.out.println(i);
            if(dfs(graph, i, new boolean[V])) return true;
        }
        
        return false;
    }
}
