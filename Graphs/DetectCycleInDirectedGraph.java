import java.util.ArrayList;

/**
 * This is a solution for GFG problem, Directed Graph Cycle:
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 */
public class DetectCycleInDirectedGraph {

    boolean[] mainVis;

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis) {
        
        mainVis[src] = true;

        if(vis[src]) return true;
        
        ArrayList<Integer> dests = graph.get(src);
        
        vis[src] = true;
        
        for(int dest : dests) {
            
            if(dfs(graph, dest, vis)) return true;
        }
        
        vis[src] = false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        
        mainVis = new boolean[V];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            
            graph.get(edge[0]).add(edge[1]);
        }
        
        for(int i = 0; i < V; i++) {
            
            if(!mainVis[i] && dfs(graph, i, new boolean[V])) return true;
        }
        
        return false;
    }
}