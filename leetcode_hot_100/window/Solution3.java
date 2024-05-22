package leetcode_hot_100.window;

import java.util.*;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2)
            return n;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i)))
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        // left : 0, 0, 0, 4 ...
        // res : 1, 2, 3, 3 ...
        return res;
    }
}
