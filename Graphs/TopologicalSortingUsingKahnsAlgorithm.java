import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingUsingKahnsAlgorithm {
    
    static ArrayList<Integer> ans = new ArrayList<>();

    // Function for Topological Sorting of the DAG using Kahn's Algorithm:
    private static void kahnsAlgorithm(ArrayList<Integer>[] graph, int v) {
        
        int[] inorder = new int[v];
        for(int i = 0; i < v; i++) {

            for(Integer dest : graph[i]) {

                inorder[dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < v; i++) {

            if (inorder[i] == 0) queue.add(inorder[i]);
        }

        while (queue.size() > 0) {
            
            int node = queue.remove();
            ans.add(node);

            for(int dest : graph[node]) {

                inorder[dest]--;
                if(inorder[dest] == 0) queue.add(dest); 
            }
        }
    }

    public static void main(String[] args) {
        
        // Graph Initialization: 
        int v = 4;
        ArrayList<Integer>[] graph = new ArrayList[v];

        for(int i = 0; i < v; i++) graph[i] = new ArrayList<Integer>();

        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(3);
        graph[2].add(3);

        /* Print Graph: 
        
        for (int i = 0; i < v; i++) {
            
            for (Integer dests : graph[i]) {
            
                System.out.println("U : " +i+ ", V: " +dests);
            }
        }

        */

        // Call dfs function for Topological Sorting of the DAG using Kahn's Algorithm:
        kahnsAlgorithm(graph, v);

        if(ans.size() != v) {

            System.out.println("Topological sorting is not possible because given graph is not DAG");
            return;
        }

        // Printing the Topological sort order:
        for (int n : ans) {
            
            System.out.print(n + " ");
        }

        System.out.println();
    }
}
