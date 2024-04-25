package classical_150.java.heap;

import java.util.*;

public class Solution502 {
    public static void main(String[] args) {
        int[] profits = { 1, 2, 3 }, capital = { 0, 1, 1 };
        Solution502 solution502 = new Solution502();
        System.out.println(solution502.findMaximizedCapital(2, 0, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i]; // 资本
            arr[i][1] = profits[i]; // 利润
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // 对arr 排序， 按照资本的大小进行排序

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x); // PriorityQueue按照逆序
        int curr = 0;
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) // 把资本消费完，并收集能干的最多项目的利润
                pq.add(arr[curr++][1]);
            if (pq.isEmpty())
                break;
            w += pq.poll(); // 把利润取出来
        }
        return w;
    }

}
