package interview_109.java;

public class Solution1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;

        int w1 = -1, w2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (word1.equals(words[i]))
                w1 = i;
            else if (word2.equals(words[i]))
                w2 = i;

            if (w1 != -1 && w2 != -1)
                res = Math.min(res, Math.abs(w1 - w2));
        }

        return res;
    }
}
