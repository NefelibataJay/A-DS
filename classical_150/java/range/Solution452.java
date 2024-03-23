package classical_150.java.range;

import java.util.*;

public class Solution452 {
    public static void main(String[] args) {
        // points[i] = [x_start, x_end] 表示水平直径在 x_start 和 x_end之间的气球。
        // 当前 x(res) 满足x_start ≤ x ≤ x_end时候，气球就爆了
        // 求最少要多少个箭能射完这些气球
        int[][] points = { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 },
                { 2, 8 } };
        Solution452 solution = new Solution452();
        System.out.println(solution.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        /**
         * 排序+贪心
         * 对右边界排序过后，必然有i>j时，有i右<=j右
         * 此时进行贪心，从左到右找到目前右边界最小的
         * 如果再往右移动，则右边界最小气球就无法引爆
         * 得到贪心思想：
         * 一定存在一种最优（射出的箭数最小）的方法，
         * 使得每一支箭的射出位置都恰好对应着某一个
         * 气球的右边界。
         * 优化：
         * 排序后第一个无法引爆的气球，其后续可以被该箭引爆
         * 的气球，其左边界一定小于当前最小右边界（当前箭），
         * 同时也小于等于下一最小右边界（下一支箭）
         * 后续可以被引爆的气球一定可以被下一支箭引爆
         * 所以遇到第一个无法击穿的气球，就可以进行下一箭的计算
         * 
         */
        // 排序 （nlogn） + 查找
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                // 当前气球的左边界大于现在的右边界，那就得多一只箭

                // 更新现在这个箭能射到的最大右边界为当前的气球的右边界
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public void toAbs(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] = Math.abs(points[i][0]);
            points[i][1] = Math.abs(points[i][1]);
        }
    }
}
