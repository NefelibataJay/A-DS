package meituan.java.spring;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = in.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j) - '0';
                // Integer.parseInt(row.charAt(i)+"");
            }
        }

        int[][] prefixSum = new int[n + 1][n + 1];

        in.close();
    }
}
