package classical_150.java.dynamicPlanning;

import java.util.*;

public class Solution139 {
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak1(String s, List<String> wordDict) {
        for (String word : wordDict)
            map.put(word, true);

        return backtrack(s, 0);
    }

    public boolean backtrack(String s, int start) {
        if (start == s.length())
            return true;

        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);
            if (map.containsKey(prefix) && backtrack(s, i + 1))
                return true;
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        for (String word : wordDict)
            map.put(word, true);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] == true)
                    break;
                if (dp[j] == false)
                    continue;
                // 为什么一定要 dp[j] == true 再检查
                // j 是从后往前检查单词的过程，意味d[j]在前面遍历过程已经没有true的可能，则当前dp[i]在但其那[j:i]的子串一定不是一个在词表内的单词
                // dp[0-i] 有可能在此表中
                String suffix = s.substring(j, i);
                if (wordDict.contains(suffix) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i - len >= 0 && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] words = { "leet", "code" };
        Solution139 solution = new Solution139();
        System.out.println(solution.wordBreak(s, Arrays.asList(words)));
    }
}
