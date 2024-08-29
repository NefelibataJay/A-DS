package leetcode_hot_100.greedy;

import java.util.*;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> answer = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int left = 0;
        while (left < n) {
            int end = last[s.charAt(left) - 'a'];
            for (int i = left; i <= end; i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
            }
            answer.add(end - left + 1);
            left = end + 1;
        }

        return answer;
    }

    public List<Integer> partitionLabels2(String s) {
        int n = s.length();
        List<Integer> answer = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < n; i++)
            last[s.charAt(i) - 'a'] = i;

        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                answer.add(end - start + 1);
                start = end + 1;
            }
        }
        return answer;
    }
}
