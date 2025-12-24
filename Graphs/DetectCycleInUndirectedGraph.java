import java.util.ArrayList;

/**
 * This is a solution for GFG problem, Undirected Graph Cycle:
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 */

/*
   DFS Logic:
*/
class DetectCycleInUndirectedGraph {
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, int parent) {
    
        vis[src] = true;
        
        ArrayList<Integer> dests = graph.get(src);
        for(int dest : dests) {
            
            if(!vis[dest] && dfs(graph, dest, vis, src)) return true;
            
            else if(vis[dest] && parent != dest) return true;
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
            
            if(dfs(graph, i, new boolean[V], -1)) return true;
        }

        return false;
    }
}


 /*
    BFS Logic:

class DetectCycleInUndirectedGraph {
    
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i = 0; i < V; i++) {
            
            boolean[] vis = new boolean[V];
            
            queue.add(new Pair(i, -1));
            vis[i] = true;
           
            while(!queue.isEmpty()) {
                
                Pair src = queue.remove();
                ArrayList<Integer> dests = graph.get(src.vertex);
                
                for(int dest: dests) {
                    
                    if(!vis[dest]) {
                        
                        queue.add(new Pair(dest, src.vertex));
                        vis[dest] = true;
                    }
                    
                    else if(dest != src.parent) return true;
                }
            }
        }
        
        return false;
    }
}        

class Pair {
    
    int vertex;
    int parent;
    
    Pair(int vertex, int parent) {
        
        this.vertex = vertex;
        this.parent = parent;
    }
}

*/