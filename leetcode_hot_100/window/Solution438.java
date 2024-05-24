package leetcode_hot_100.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m)
            return res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < m; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < n - m; i++) {
            sCount[s.charAt(i) - 'a']--; // 滑动窗口左边 --
            sCount[s.charAt(i + m) - 'a']++; // 滑动窗口右边 ++

            if (Arrays.equals(sCount, pCount)) // 每次判断两个数组是否相等
                res.add(i + 1);
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m)
            return res;

        int[] count = new int[26];

        for (int i = 0; i < m; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        int differ = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0)
                differ++;
        }

        if (differ == 0)
            res.add(0);

        for (int i = 0; i < n - m; i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                differ--; // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
            else if (count[s.charAt(i) - 'a'] == 0)
                differ++; // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同

            count[s.charAt(i) - 'a']--;

            if (count[s.charAt(i + m) - 'a'] == -1)
                differ--; // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
            else if (count[s.charAt(i + m) - 'a'] == 0)
                differ++; // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
            count[s.charAt(i + m) - 'a']++;

            if (differ == 0)
                res.add(i + 1);
        }
        return res;
    }
}
