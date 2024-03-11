package classical_100.java;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring1("abcabcbb"));
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] chars = new int[128];
        int max = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = chars[c];
            if (index > start ) {
                start = index;
            }
            max = Math.max(max, i - start + 1);
            chars[c] = i+1;
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int left = 0, right = 1;
        int max = 0;

        // left 和 right 之间的字符串是不重复的
        // left 和 right 构成 一个左闭右开的区间，中间的字符不能重复，一旦重复更新左指针
        while (right < s.length()) {
            while (s.substring(left, right).contains(String.valueOf(s.charAt(right)))) {
                // 循环判断当前 left 和 right 这个区间内是否还存在当前重复的字符，一直存在一直更新左指针
                left++;
            }
            right++; // 不重复的时候更新右指针
            max = Math.max(max, right - left); // 计算当前最长的子串长度
        }
        return max;
    }
}
