package classical_150.java.graph;

import java.util.*;

public class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1]; // 记录节点访问的状态
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 0 }); // 起点状态，表示当前位于起点 1，移动次数为 0。

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i <= 6; i++) {
                int next = p[0] + i;

                if (next > n * n)
                    break; // 超出边界

                int[] rc = id2rc(next, n); // 计算当前id 对应的行列下标

                if (board[rc[0]][rc[1]] != -1)
                    // 该位置是蛇或者梯子
                    next = board[rc[0]][rc[1]];

                if (next == n * n)
                    // 到达终点了，返回当前移动步数+1
                    return p[1] + 1;

                if (!visited[next]) {
                    // 当前位置没有走过
                    queue.offer(new int[] { next, p[1] + 1 });
                    visited[next] = true;
                }
            }
        }
        return -1; // 走不到终点
    }

    public int[] id2rc(int id, int n) {
        // id 转换成行和列
        // 这里我们先计算正常的位置，也就是 标号id = 1, 的位置为 （0，0）
        // 每行n个数，该元素所在行一定是 (id-1)/n 向下取整，
        // 列 则是 (id - 1) % n
        int r = (id - 1) / n, c = (id - 1) % n;

        if (r % 2 == 1) {
            // 若当前行是偶数，则编号方向从左向右
            // 若当前行是奇数，则编号方向从右向左
            c = n - 1 - c;
        }
        // 我们在吧行的位置倒过来，也就是从下往上的行编号
        return new int[] { n - 1 - r, c };
    }
}