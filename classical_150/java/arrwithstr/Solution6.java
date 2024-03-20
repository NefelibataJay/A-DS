package classical_150.java.arrwithstr;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert1(s, 4));
    }

    public String convert1(String s, int numRows) {
        if (s.length() <= numRows || numRows < 2) return s;
        List<String> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add("");
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.set(i, rows.get(i) + c);
            // 当第一行的时候，flag = 1，当最后一行的时候，flag = -1
            // 这样就可以控制i从0到numRows-1，然后再从numRows-1到0
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        String result = "";
        for (String row : rows) {
            result += row;
        }
        return result;
    }

    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows < 2) return s;
        String ans = "";
        int step = 2*numRows-2;
        int len = s.length();

        for (int j = 0; j<numRows; j++) {
            for (int i = j; i < len; i += step) {
                ans = ans + s.charAt(i);
                // 计算还剩几行 numRows - j - 1
                // 处理中间行
                if ((i + 2 * (numRows - j - 1) < len) && j != 0 && j != numRows-1)
                    ans = ans + s.charAt(i + 2 * (numRows - j - 1));
            }
        }
        return ans;
    }
}
