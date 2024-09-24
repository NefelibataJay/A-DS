package daybyday.java;

import java.util.*;

/**
 * Solution2207
 */
public class Solution2207 {
    public static void main(String[] args) {
        System.out.println(maximumSubsequenceCount("abdcdvc", "ac"));
    }

    public static long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        long res = 0;

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c == pattern.charAt(1)) {
                res += cnt1; // 遇到匹配的第二个字符就加上之前匹配的第一个字符数
                cnt2++;
            }
            if (c == pattern.charAt(0)) {
                cnt1++;
            }
        }

        return res + Math.max(cnt1, cnt2); // Math.max(cnt1, cnt2)就是在头部或者尾部插入pattern[0]或者pattern[1]
    }

}