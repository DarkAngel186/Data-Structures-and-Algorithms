import java.util.ArrayList;
import java.util.Arrays;

class Edge {

    int v;
    int dist;
    
    Edge(int v, int dist) {

        this.v = v;
        this.dist = dist;
    }
}

public class BellmanFordAlgorithm {

    static int[] ans;
    
    // function to calculate shortest path for all nodes from source node using Bellman Ford's Algorithm:
    private static void solve(ArrayList<ArrayList<Edge>> graph, int src, int v) {

        ans[src] = 0;

        for(int i = 0; i < v - 1; i++) {

            // System.out.println("Outer for");
            
            for(int u = 0; u < v; u++) {

                // System.out.println("Inner for");

                ArrayList<Edge> dests = graph.get(u);

                for(Edge dest : dests) {
                    
                    // System.out.println("Inner Inner for");

                    if(ans[dest.v] > ans[u] + dest.dist) {

                        ans[dest.v] = ans[u] + dest.dist;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        
        // Graph Initialization: 
        int v = 5;
        int src = 0;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        ans = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);

        for(int i = 0; i < v; i++) graph.add(new ArrayList<Edge>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));

        graph.get(1).add(new Edge(4, -1));
        graph.get(1).add(new Edge(2, -4));
        
        graph.get(2).add(new Edge(3, 2));

        graph.get(3).add(new Edge(4, 4));

        /* Print Graph: 

        int src = 0;
        for (ArrayList<Edge> arrayList : graph) {
            
            for (Edge edge : arrayList) {
            
                System.out.println("U : " +src+ ", V: " +edge.v+ " Weight : " +edge.dist);
            }

            src++;
        }
        */

        // Call solve function to calculate shortest path for all nodes from source node using Bellman Ford's Algorithm
        solve(graph, src, v);

        // Printing the shortest path for all nodes:
        for (int i = 0; i < ans.length; i++) {
            
            System.out.println("Node : " +i+ ", Distance: " +ans[i]);
        }
    }
}
