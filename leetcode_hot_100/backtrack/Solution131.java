package leetcode_hot_100.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    // 分割回文串
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        solution131.partition("aab");
    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0, 0);
        return res;
    }

    public void backTrack(String s, int i, int start) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (i < s.length() - 1) {
            backTrack(s, i + 1, start);
        }

        if (isPalindrome(start, i, s)) {
            path.add(s.substring(start, i + 1));
            backTrack(s, i + 1, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
