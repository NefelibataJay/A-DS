package daybyday.java;

public class Solution2414 {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if (n < 2)
            return n;
        int res = 1;
        int left = 0, right = 0;

        while (left < n) {
            right = left + 1;
            while (right < n && s.charAt(right) == s.charAt(right - 1) + 1)
                right++;

            res = Math.max(res, right - left + 1);
            left = right;
        }

        return res;
    }
}
