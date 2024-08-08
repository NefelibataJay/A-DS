package leetcode_hot_100.graph;

public class Solution200 {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, 'w');
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col, char c) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0)
            return;
        if (grid[row][col] == '0' || grid[row][col] == 'w')
            return;
        grid[row][col] = c;
        dfs(grid, row, col + 1, c);
        dfs(grid, row + 1, col, c);
        dfs(grid, row, col - 1, c);
        dfs(grid, row - 1, col, c);
    }

}
