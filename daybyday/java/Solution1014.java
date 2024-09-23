package daybyday.java;

/**
 * Solution1014
 */
public class Solution1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int res = 0;
        int max = values[0];

        for (int i = 1; i < n; i++) {
            res = Math.max(res, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return res;
    }

    public int maxScoreSightseeingPair1(int[] values) {
        int n = values.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, i - j + values[i] + values[j]);
            }
        }
        return res;
    }
}