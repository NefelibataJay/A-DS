package leetcode_hot_100.matrix;

public class Solution240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { -5 } };
        int target = -5;
        Solution240 solution240 = new Solution240();
        System.out.println(solution240.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] > target)
                col--;
            else
                row++;
        }

        return false;
    }
}
