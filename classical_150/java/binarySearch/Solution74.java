package classical_150.java.binarySearch;

public class Solution74 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        Solution74 solution = new Solution74();
        System.out.println(solution.searchMatrix(matrix, 11));
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        // 把整个二维数组当成一个数组进行查找
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            int x = matrix[mid / n][mid % m];
            if (target > x)
                low = mid + 1;
            else if (target < x)
                high = mid - 1;
            else
                return true;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low; // 防止溢出
            if (matrix[mid][0] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        // 此时low 一定刚好指向大于target的那一行
        return low - 1;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
