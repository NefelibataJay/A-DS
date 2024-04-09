package classical_150.java.graph;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 每次都求一个岛屿的面积
                    // 因为在递归中，遇到0和2以及超越边界的时候会直接返回不会继续递归
                    // 当我们这个岛周围都是0和边界时，就自动计算了
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    public int area(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
            return 0;

        if (grid[i][j] == '0' || grid[i][j] == '2')
            return 0; // 0表示水域，2表示已经访问过
        grid[i][j] = '2'; // 标记为已访问

        // 访问上、下、左、右四个相邻结点
        return 1 + area(grid, i - 1, j) +
                area(grid, i + 1, j) +
                area(grid, i, j - 1) +
                area(grid, i, j + 1);
    }
}
