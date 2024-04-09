package classical_150.java.graph;

public class Solution200 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
        solution200.dfs(grid, 0, 0);
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    // 不用担心重复进入一个岛，被访问过的岛都是2，不会再次进入这个岛
                    dfs(grid, r, c);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
            return;

        if (grid[i][j] == '0' || grid[i][j] == '2')
            return; // 0表示水域，2表示已经访问过
        grid[i][j] = '2'; // 标记为已访问

        // 访问上、下、左、右四个相邻结点
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
