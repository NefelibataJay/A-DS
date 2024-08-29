package daybyday.java;

public class Solution3142 {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < grid.length && grid[i][j] != grid[i + 1][j])
                    return false;
                if (j + 1 < grid[0].length && grid[i][j] == grid[i][j + 1])
                    return false;
            }
        }
        return true;
    }
}
