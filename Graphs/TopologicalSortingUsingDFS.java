import java.util.ArrayList;

public class TopologicalSortingUsingDFS {

    static boolean[] mainVis;
    static ArrayList<Integer> ans = new ArrayList<>();

    // Function for Topological Sorting of the DAG using PostOrder DFS:
    private static boolean dfs(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        
        if(vis[src]) return true;
        
        ArrayList<Integer> dests = graph[src];
        vis[src] = true;

        for(int dest : dests) {
            
            
            if(dfs(graph, dest, vis)) return true;
        }

        if(!mainVis[src]) {

            ans.add(src);
            mainVis[src] = true;
        }

        vis[src] = false;
        return false;
    }

    public static void main(String[] args) {
        
        // Graph Initialization: 
        // int v = 6;
        int v = 4;
        ArrayList<Integer>[] graph = new ArrayList[v];
        mainVis = new boolean[v];

        for(int i = 0; i < v; i++) graph[i] = new ArrayList<Integer>();

        // graph[2].add(3);
        // graph[3].add(1);
        // graph[4].add(0);
        // graph[4].add(1);
        // graph[5].add(0);
        // graph[5].add(1);

        graph[1].add(0);
        graph[2].add(0);
        graph[3].add(1);
        graph[3].add(2);

        /* Print Graph: 
        
        for (int i = 0; i < v; i++) {
            
            for (Integer dests : graph[i]) {
            
                System.out.println("U : " +i+ ", V: " +dests);
            }
        }

        */

        // Call dfs function for Topological Sorting of the DAG using PostOrder DFS:
        for(int i = 0; i < v; i++) {
            
            if(!mainVis[i] && dfs(graph, i, new boolean[v])) {

                System.out.println("Topological sorting is not possible because given graph is not DAG");
                return;
            }
        }

        // Printing the Topological sort order:
        for (int n : ans) {
            
            System.out.print(n + " ");
        }

        System.out.println();
    }
}