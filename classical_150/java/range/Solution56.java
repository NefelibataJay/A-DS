package classical_150.java.range;

import java.util.*;

public class Solution56 {
    public static void main(String[] args) {
        int[][] internals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        Solution56 solution = new Solution56();
        System.out.println(Arrays.deepToString(solution.merge(internals)));
    }

    public int[][] merge(int[][] intervals) {
        // 需要应对的是 left = [2,5]     right -> [0,1]  [1,3]  [3,4]  [3,7] [6,7]

        if (intervals.length <= 1) return intervals;
        List<int[]> res = new ArrayList<int[]>();

        // 先进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        for (int i=0; i<intervals.length; i++){
            int start = intervals[i][0], end = intervals[i][1];
            if (res.isEmpty() || res.get(res.size() -1)[1] < start){
                // 若当前区间的左边界已经大于列表中最后一个区间的右边界
                // 注：由于我们已经排序，这就以为我们按照排序后的internal存放的结果也是有序的
                res.add(intervals[i]);
            } else  // 更新列表中最后一个元素的右边界
                res.get(res.size()-1)[1] = Math.max(res.get(res.size() - 1)[1], end);
        }

        return res.toArray(new int[res.size()][]);
    }
}
