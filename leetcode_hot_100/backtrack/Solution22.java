package leetcode_hot_100.backtrack;

import java.util.*;

public class Solution22 {
    // 括号生成
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(3);
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0);
        return res;
    }

    public void backTrack(int n, int open, int close) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backTrack(n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backTrack(n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
