import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a solution for Leetcode problem, Course Schedule 2:
 * https://leetcode.com/problems/course-schedule-ii/description/
 * 
 * This problem is solved using Topological sorting using Kahn's Algorithm.
 * Course Schedule 1 can be solved using similar approach.
 */
public class CourseScheduleII {
    
    public int[] findOrder(int n, int[][] edges) {

        int[] ans = new int[n];
        int[] indegree = new int[n];

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {

            graph[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {

            if(indegree[i] == 0) queue.add(i);
        }

        if(queue.size() == 0) return new int[0];

        int idx = 0;
        while(queue.size() > 0) {

            int curr = queue.remove();
            ans[idx] = curr;
            idx++;

            ArrayList<Integer> dests = graph[curr];
            for(int dest : dests) {

                indegree[dest]--;
                if(indegree[dest] == 0) queue.add(dest);
            }
        }

        if(idx < n) return new int[0];

        return ans;
    }
}
