package leetcode_hot_100.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty() && count > 0) {
            res++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    queue.offer(new int[] { x - 1, y });
                    grid[x - 1][y] = 2;
                    count--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    queue.offer(new int[] { x, y - 1 });
                    grid[x][y - 1] = 2;
                    count--;
                }
                if (x + 1 < rows && grid[x + 1][y] == 1) {
                    queue.offer(new int[] { x + 1, y });
                    grid[x + 1][y] = 2;
                    count--;
                }
                if (y + 1 < cols && grid[x][y + 1] == 1) {
                    queue.offer(new int[] { x, y + 1 });
                    grid[x][y + 1] = 2;
                    count--;
                }
            }
        }
        return count == 0 ? res : -1;
    }
}
