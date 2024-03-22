package classical_150.java.range;

import java.util.*;

public class Solution57 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        Solution57 solution = new Solution57();
        System.out.println(Arrays.deepToString(solution.insert2(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (end < newInterval[0] || start > newInterval[1]) {
                res.add(intervals[i]);
            } else {
                // end >= newInterval[0] || start <= newInterval[1]
                int j = i;
                while (j < intervals.length && intervals[j][1] < newInterval[1]) {
                    j++;
                } // 找到一个足以包含整个新区间的
                j--;

            }

        }

        return res.toArray(new int[res.size()][]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 当前的左边界大于新区间的右边界
                if (!placed) { // 插入我们下面找到的临时区间
                    ansList.add(new int[] { left, right });
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 当前的右边界小于新区间的左边界
                ansList.add(interval);
            } else {
                // 与新区间有交集，计算它们的并集
                // 计算最小的左边界和最大的右边界
                // 可以认为吧当前的区间和需要插入的新区间合并成一个临时区间，然后依次先后遍历
                // 这个临时区间在下一次遍历时成为了需要插入的新区间，就相当扩大了我们要插入的区间
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!placed) {
            // 现在这个区间集合内不包含和新区间的交集
            // 所以我们直接插入到最后方
            ansList.add(new int[] { left, right });
        }

        return ansList.toArray(new int[ansList.size()][]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int L = newInterval[0];
        int R = newInterval[1];

        // 二分查找（左），参考bisect.bisect_left
        int pL = 0;
        int r = intervals.length;
        while (pL < r) {
            int m = (pL + r) / 2;
            if (intervals[m][1] < L) {
                pL = m + 1;
            } else {
                r = m;
            }
        }

        // 二分查找（右），参考bisect.bisect_right
        int pR = pL;
        r = intervals.length;
        while (pR < r) {
            int m = (pR + r) / 2;
            if (intervals[m][0] > R) {
                r = m;
            } else {
                pR = m + 1;
            }
        }

        // 替换片段
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < pL; i++) {
            result.add(intervals[i]);
        }
        if (pL == pR) {
            result.add(newInterval);
        } else {
            result.add(new int[] { Math.min(L, intervals[pL][0]), Math.max(R, intervals[pR - 1][1]) });
        }
        for (int i = pR; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
