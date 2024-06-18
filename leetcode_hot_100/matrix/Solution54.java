package leetcode_hot_100.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        List<Integer> res = solution54.spiralOrder(matrix);
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        int sr = 0, sc = 0, er = r - 1, ec = c - 1;

        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                res.add(matrix[sr][j]);
            }
            sr++;
            for (int i = sr; i <= er; i++) {
                res.add(matrix[i][ec]);
            }
            ec--;
            if (sr > er || sc > ec)
                break;
            for (int j = ec; j >= sc; j--) {
                res.add(matrix[er][j]);
            }
            er--;
            for (int i = er; i >= sr; i--) {
                res.add(matrix[i][sc]);
            }
            sc++;
        }

        return res;

    }
}
