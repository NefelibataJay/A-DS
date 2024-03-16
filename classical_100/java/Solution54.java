package classical_100.java;

import java.util.*;

public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution = new Solution54();
        int[][] matrix = {{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        int curMaxR = r;
        int curMaxC = c;

        int curMinR = -1;
        int curMinC = -1;

        int i = 0;
        int j = 0;

        for (int count=0;count<r*c;) {
            while (j < curMaxC && count<r*c) { // 从左到右
                res.add(matrix[i][j]);
                j++;
                count++;
            }

            j--; // 这个时候j已经超出最右边的位置，需要回退一步
            curMinR = i; // 更新最小行的位置
            i++; // 当前行已被访问，需要下移一行

            while (i < curMaxR && count<r*c) { // 从上到下
                res.add(matrix[i][j]);
                i++;
                count++;
            }

            i--; // 这个时候i已经超出最下边的位置，需要回退一步
            curMaxC = j; // 更新最大列的位置
            j--; // 当前列已被访问，需要左移一列

            while (j > curMinC && count<r*c) { // 从右到左
                res.add(matrix[i][j]);
                j--;
                count++;
            }

            j++; // 这个时候j已经超出最左边的位置，需要回退一步
            curMaxR = i; // 更新最大行的位置
            i--; // 当前行已被访问，需要上移一行

            while (i > curMinR && count<r*c) { // 从下到上
                res.add(matrix[i][j]);
                i--;
                count++;
            }

            i++; // 这个时候i已经超出最上边的位置，需要回退一步
            curMinC = j; // 更新最小列的位置
            j++; // 当前列已被访问，需要右移一列
        }
        return res;
    }
}

