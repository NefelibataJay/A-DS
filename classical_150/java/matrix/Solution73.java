package classical_150.java.matrix;

import java.util.Arrays;

public class Solution73 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Solution73 solution73 = new Solution73();
        solution73.setZeroes1(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] clos = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = clos[j] = 1;
                }
            }
        }

        for (int i=0; i<m; i++){
            if (rows[i] != 1) continue;
            for (int j=0; j<n; j++) matrix[i][j] = 0;
        }

        for (int j=0; j<n; j++){
            if (clos[j] != 1) continue;
            for (int i=0; i<m; i++) matrix[i][j] = 0;
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (rows[i] || cols[j]) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }

    }

    public void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;

        for (int j=0; j<col; j++){
            if (matrix[0][j]==0) {
                row0_flag = true;
                break;
            }
        }

        for (int i=0; i<row; i++){
            if (matrix[i][0]==0){
                col0_flag = true;
                break;
            }
        }

        // 把第一行第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                    // 该元素对应的的整行和整列都需要为0，所以我们只让这个元素的第一行和第一列为0
                    // 因为我们上面遍历过第一行和第一列，知道了第一行和第一列是不是有0元素
                    // 所以我们此处都是从第二行和第二例开始
                }
            }
        }

        // 置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    // 如果该行对应的第一列元素为0 或者 该列对应的第一行元素为0
                    // 代表该行，列的元素都为0
                    matrix[i][j] = 0;
                }
            }
        }

        // 判断第一行第一列的元素需不需要设置为0
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
