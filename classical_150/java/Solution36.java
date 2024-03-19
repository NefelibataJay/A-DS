package classical_150.java;

public class Solution36 {
    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution36.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];  // 记录每一行的数字对应出现的次数，第一维是行数，第二维是每个数字出现的次数
        int[][] columns = new int[9][9];  // 记录每一列的数字对应出现的次数，第一维是列数，第二维是每个数字出现的次数
        int[][][] subBoxes = new int[3][3][9];  // 计算每个3×3矩阵内数字出现的次数，第三维是每个数字出现的次数

        for (int i = 0; i<9; i++){
            for (int j=0; j<9; j++){
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;  // 计算index,可以认为是在将char转换为数字， 当前 c-'0' = 数字型的c，再 减1就是index
                    rows[i][index]++;  // 记录行
                    columns[j][index]++;  // 记录列
                    subBoxes[i / 3][j / 3][index]++;  // i / 3 和 j / 3 是为了计算出当前数字在第几个3×3矩阵内
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subBoxes[i / 3][j / 3][index] > 1) {
                        // 如果出现了重复的数字，就返回false
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
