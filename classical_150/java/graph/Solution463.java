package classical_150.java.graph;

import java.util.ArrayList;

public class Solution463 {
    public int islandPerimeter2(int[][] grid) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    a++; // 记录等于1的个数
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        b++; // 上边有相邻的点
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        b++; // 右边有相邻的点

                }
            }
        }

        // a * 4是每个1的四条边，b * 2是每个相邻的1的边
        return a * 4 - b * 2;

    }

    public int islandPerimeter(int[][] grid) {
        int res = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int perimeter = dfs(grid, r, c);
                    res = perimeter;
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == 0)
            return 1;
        if (grid[r][c] == 2)
            return 0;

        grid[r][c] = 2;
        return dfs(grid, r - 1, c) +
                dfs(grid, r + 1, c) +
                dfs(grid, r, c - 1) +
                dfs(grid, r, c + 1);
    }

}
