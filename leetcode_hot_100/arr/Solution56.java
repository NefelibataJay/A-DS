package leetcode_hot_100.arr;

import java.util.*;

public class Solution56 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }; // [[1,6],[8,10],[15,18]]
        Solution56 solution56 = new Solution56();
        solution56.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            } else {// intervals[i][0] <= end
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        res.add(new int[] { start, end });

        return res.toArray(new int[res.size()][]);
    }
}
