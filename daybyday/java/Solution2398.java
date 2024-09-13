package daybyday.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2398 {
    public static void main(String[] args) {
        int[] chargeTimes = { 19, 63, 21, 8, 5, 46, 56, 45, 54, 30, 92, 63, 31, 71, 87, 94, 67, 8, 19, 89, 79, 25 };
        int[] runningCosts = { 91, 92, 39, 89, 62, 81, 33, 99, 28, 99, 86, 19, 5, 6, 19, 94, 65, 86, 17, 10, 8, 42 };
        long budget = 85;
        Solution2398 solution2398 = new Solution2398();
        System.out.println(solution2398.maximumRobots(chargeTimes, runningCosts, budget));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int res = 0;

        long runningCoustSum = 0;
        Deque<Integer> que = new ArrayDeque<>(); // 单调队列，滑动窗口
        for (int i = 0, j = 0; i < n; i++) {
            while (!que.isEmpty() && chargeTimes[que.peekLast()] <= chargeTimes[i])
                que.pollLast();
            // chargeTimes[que.peekLast()] <= chargeTimes[i] 当前队内最大元素 比现在的还小，就一直出队
            // 保持队尾一直是最大元素,形成单调队列

            runningCoustSum += runningCosts[i];
            que.addLast(i);

            // 从前往后计算，que.peekFirst()一直都是 chargeTimes最小的下标，一旦超过了budget，就先删除最小的元素
            while (j <= i && (i - j + 1) * runningCoustSum + chargeTimes[que.peekFirst()] > budget) {
                if (!que.isEmpty() && que.peekFirst() == j)
                    que.pollFirst(); // 当前j就是最前面元素，则出队
                runningCoustSum -= runningCosts[j++];
            }
            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    public int maximumRobotsF1(int[] chargeTimes, int[] runningCosts, long budget) {
        // 超时
        int n = chargeTimes.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int curNum = 0;
            int max = Integer.MIN_VALUE;
            long sum = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, chargeTimes[j]);
                sum += runningCosts[j];
                if ((max + (j - i + 1) * sum) > budget) {
                    break;
                } else {
                    curNum++;
                }
            }
            res = Math.max(res, curNum);
        }

        return res;
    }
}
