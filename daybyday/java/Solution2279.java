package daybyday.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2279 {
    // 装满石头的背包的最大数量

    public static void main(String[] args) {
        int[] capacity = { 5, 2, 1, 1 };
        int[] rocks = { 3, 2, 0, 0 };
        Solution2279 solution2279 = new Solution2279();
        System.out.println(solution2279.maximumBags(capacity, rocks, 2));
    }

    public int maximumBags2(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        for (int i = 0; i < n; i++)
            capacity[i] -= rocks[i];

        Arrays.sort(capacity);

        for (int i = 0; i < n; i++) {
            additionalRocks -= capacity[i];

            if (additionalRocks == 0)
                return i + 1;
            else if (additionalRocks < 0)
                return i;
        }
        return n;
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int res = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大根堆

        for (int i = 0; i < n; i++) {
            if (capacity[i] <= rocks[i]) {
                res++;
            } else {
                int cnt = capacity[i] - rocks[i];
                if (cnt <= additionalRocks) {
                    queue.offer(cnt);
                    additionalRocks -= cnt;
                    res++;
                } else {
                    if (!queue.isEmpty() && cnt < queue.peek()) {
                        Integer poll = queue.poll(); // 取出上一次花费最多石头的数量
                        queue.offer(cnt); // 当前的花费入堆
                        additionalRocks += poll - cnt;
                    }
                }
            }
        }
        return res;
    }
}
