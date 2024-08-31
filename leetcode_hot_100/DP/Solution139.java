package leetcode_hot_100.DP;

import java.util.*;

public class Solution139 {
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("leet");
        arrayList.add("code");
        // arrayList.add("sand");
        // arrayList.add("and");
        // arrayList.add("cat");

        System.out.println(solution139.wordBreak("leetcode", arrayList));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    // 深度搜索超时，需要优化
    public boolean dfs(String s, List<String> wordDict, int cur) {
        if (cur >= s.length())
            return true;
        for (String word : wordDict) {
            if (cur + word.length() > s.length())
                continue;
            if (s.substring(cur, cur + word.length()).equals(word) && dfs(s, wordDict, cur + word.length()))
                return true;
        }
        return false;
    }
}
