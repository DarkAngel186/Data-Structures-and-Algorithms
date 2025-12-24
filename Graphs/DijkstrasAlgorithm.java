import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge {

    int v;
    int dist;
    
    Edge(int v, int dist) {

        this.v = v;
        this.dist = dist;
    }
}

public class DijkstrasAlgorithm {
    
    static int[] ans;

    // function to calculate shortest path for all nodes from source node using Dijkstra's Algorithm:
    private static void solve(ArrayList<ArrayList<Edge>> graph, int src) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Edge(src, 0));
        ans[src] = 0;

        while(pq.size() > 0) {
            
            Edge e = pq.remove();
            ArrayList<Edge> dests = graph.get(e.v);

            for(Edge dest : dests) {

                if(ans[dest.v] > ans[e.v] + dest.dist) {

                    ans[dest.v] = ans[e.v] + dest.dist;
                    pq.add(new Edge(dest.v, ans[dest.v]));
                }
            }
        }
    }

    public static void main(String[] args) {
        
        // Graph Initialization: 
        int v = 6;
        int src = 0;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        ans = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);

        for(int i = 0; i < v; i++) graph.add(new ArrayList<Edge>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));

        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        
        graph.get(2).add(new Edge(4, 3));

        graph.get(3).add(new Edge(5, 1));

        graph.get(4).add(new Edge(3, 2));
        graph.get(4).add(new Edge(5, 5));

        /* Print Graph: 

        int src = 0;
        for (ArrayList<Edge> arrayList : graph) {
            
            for (Edge edge : arrayList) {
            
                System.out.println("U : " +src+ ", V: " +edge.v+ " Weight : " +edge.dist);
            }

            src++;
        }
        */

        // Call solve function to calculate shortest path for all nodes from source node using Dijkstra's Algorithm
        solve(graph, src);

        // Printing the shortest path for all nodes:
        for (int i = 0; i < ans.length; i++) {
            
            System.out.println("Node : " +i+ ", Distance: " +ans[i]);
        }
    }
}
