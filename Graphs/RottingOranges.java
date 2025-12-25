import java.util.LinkedList;
import java.util.Queue;

class Pair {

    int i;
    int j;
    int time;

    Pair(int i, int j, int time) {

        this.i = i;
        this.j = j;
        this.time = time;
    }
}

/**
 * This is a solution for Leetcode problem, Rotting Oranges:
 * https://leetcode.com/problems/rotting-oranges/description/
 * 
 * This problem is solved using Multi-source BFS approach
 */

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {

                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int mins = 0;

        while(queue.size() > 0) {

            Pair p = queue.remove();

            if(p.i - 1 >= 0 && grid[p.i - 1][p.j] == 1 && !vis[p.i - 1][p.j]) {

                queue.add(new Pair(p.i - 1, p.j, p.time + 1));
                vis[p.i - 1][p.j] = true;
            }

            if(p.i + 1 < m && grid[p.i + 1][p.j] == 1 && !vis[p.i + 1][p.j]) {

                queue.add(new Pair(p.i + 1, p.j, p.time + 1));
                vis[p.i + 1][p.j] = true;
            }

            if(p.j - 1 >= 0 && grid[p.i][p.j - 1] == 1 && !vis[p.i][p.j - 1]) {

                queue.add(new Pair(p.i, p.j - 1, p.time + 1));
                vis[p.i][p.j - 1] = true;
            }

            if(p.j + 1 < n && grid[p.i][p.j + 1] == 1 && !vis[p.i][p.j + 1]) {

                queue.add(new Pair(p.i, p.j + 1, p.time + 1));
                vis[p.i][p.j + 1] = true;
            }

            mins = Math.max(mins, p.time);
        }

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(!vis[i][j] && grid[i][j] == 1) return -1;
            }
        }

        return mins;
    }
}
