package leetcode_hot_100.DP;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.longestPalindrome("bb"));
    }

    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxStart = 0; // 最长回文串的起点
        int maxEnd = 0; // 最长回文串的终点
        int maxLen = 1; // 最长回文串的长度

        for (int r = 1; r < n; r++) {
            for (int l = 0; l < n; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2)
            return s;

        String ans = "";
        String cur = "";
        for (int i = 1; i < n; i++) {
            int right = 1;
            while (i + right < n && s.charAt(i) == s.charAt(i + right))
                right++; // 向右寻找相同字符

            int left = 1;
            while (i - left >= 0 && s.charAt(i) == s.charAt(i - left))
                left++; // 向左寻找相同字符

            cur = check(s, i - left + 1, i + right - 1);
            if (cur.length() >= ans.length())
                ans = cur + "";
        }
        return ans;
    }

    public String check(String s, int left, int right) {
        int offset = 1;
        while (right + offset < s.length() && left - offset >= 0) {
            if (s.charAt(offset + right) != s.charAt(left - offset))
                break;
            else
                offset++;
        }

        return s.substring(left - offset + 1, right + offset);
    }
}
