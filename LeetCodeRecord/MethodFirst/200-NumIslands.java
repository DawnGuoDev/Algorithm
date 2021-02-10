package MethodFirst;

import java.util.LinkedList;
import java.util.Queue;

class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            int tempi = temp[0];
            int tempj = temp[1];

            if (tempi - 1 >= 0 && grid[tempi - 1][tempj] == '1') {
                grid[tempi - 1][tempj] = '0';
                queue.offer(new int[]{tempi - 1, tempj});
            }

            if (tempi + 1 < grid.length && grid[tempi + 1][tempj] == '1') {
                grid[tempi + 1][tempj] = '0';
                queue.offer(new int[]{tempi + 1, tempj});
            }
            
            if (tempj - 1 >= 0 && grid[tempi][tempj - 1] == '1') {
                grid[tempi][tempj - 1] = '0';
                queue.offer(new int[]{tempi, tempj - 1});
            }

            if (tempj + 1 < grid[0].length && grid[tempi][tempj + 1] == '1') {
                grid[tempi][tempj + 1] = '0';
                queue.offer(new int[]{tempi, tempj + 1});
            }
        }
    }
}
