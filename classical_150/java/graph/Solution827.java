package classical_150.java.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution827 {
    public int largestIsland(int[][] grid) {
        int res = 0;
        ArrayList<Integer> areaList = new ArrayList<>(); // 记录面积
        areaList.add(0); // 首位为0，表示水域的陆地面积为0
        areaList.add(0); // 为1的陆地，后面都是0；
        // >= 2: 岛屿

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, areaList.size());
                    areaList.add(area);
                }
            }
        }

        if (areaList.size() == 1)
            return 1; // 没有一个岛，全是海。

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    int topIndex = r - 1 < 0 ? 0 : grid[r - 1][c];
                    int bottomIndex = r + 1 >= grid.length ? 0 : grid[r + 1][c];
                    int leftIndex = c - 1 < 0 ? 0 : grid[r][c - 1];
                    int rightIndex = c + 1 >= grid[0].length ? 0 : grid[r][c + 1];
                    int area = 1 + areaList.get(topIndex);

                    if (bottomIndex != topIndex) {
                        area += areaList.get(bottomIndex);
                    }
                    if (leftIndex != topIndex && leftIndex != bottomIndex) {
                        area += areaList.get(leftIndex);
                    }
                    if (rightIndex != topIndex && rightIndex != bottomIndex && rightIndex != leftIndex) {
                        area += areaList.get(rightIndex);
                    }

                    res = Math.max(res, area);
                }
            }
        }

        if (res == 0)
            return areaList.get(2); // 整个区域就是一个岛，没有海洋；

        return res;

    }

    public int dfs(int[][] grid, int r, int c, int n) {
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0)
            return 0;
        if (grid[r][c] != 1)
            return 0;

        grid[r][c] = n;
        return 1 + dfs(grid, r - 1, c, n) +
                dfs(grid, r + 1, c, n) +
                dfs(grid, r, c - 1, n) +
                dfs(grid, r, c + 1, n);
    }

    public int largestIsland1(int[][] grid) {
        // 解法1：标记所有岛屿
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n^2)

        // 步骤1：标记所有的岛屿，并统计每个岛屿的面积
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n^2)

        int n = grid.length;
        int[] count = new int[n * n + 2];
        int tag = 2;
        int maxArea = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    count[tag] = dfs2(grid, i, j, tag);
                    maxArea = Math.max(maxArea, count[tag]);
                    ++tag;
                }
            }
        }

        // 步骤2：遍历所有海洋格子，尝试将其变成陆地，统计改变后的陆地面积
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int up = i - 1 >= 0 ? grid[i - 1][j] : 0;
                    int down = i + 1 < n ? grid[i + 1][j] : 0;
                    int left = j - 1 >= 0 ? grid[i][j - 1] : 0;
                    int right = j + 1 < n ? grid[i][j + 1] : 0;

                    int area = 1 + count[up];

                    if (down != up) {
                        area += count[down];
                    }
                    if (left != up && left != down) {
                        area += count[left];
                    }
                    if (right != up && right != down && right != left) {
                        area += count[right];
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs2(int[][] grid, int i, int j, int tag) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = tag;
        return 1 + dfs2(grid, i - 1, j, tag) + dfs2(grid, i + 1, j, tag) + dfs2(grid, i, j - 1, tag)
                + dfs2(grid, i, j + 1, tag);
    }
}