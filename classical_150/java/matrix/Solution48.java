package classical_150.java.matrix;

import java.util.Arrays;

public class Solution48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
        Solution48 solution48 = new Solution48();
        solution48.rotate(matrix);
        for (int[] ins : matrix) {
            System.out.println(Arrays.toString(ins));
        }
    }

    public void rotate(int[][] matrix){
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++){
                result[j][n-i-1] = matrix[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }

    public void rotate1(int[][] matrix){
        int n = matrix.length;

        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
