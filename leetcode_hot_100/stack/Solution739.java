package leetcode_hot_100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution739 {
    // 每日温度
    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        Solution739 solution739 = new Solution739();
        solution739.dailyTemperatures(temperatures);
    }

    public int[] dailyTemperaturesStack(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        answer[n - 1] = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty())
                stack.push(i);
            else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return answer;
    }

    public int[] dailyTemperaturesBest(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        answer[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i] && answer[j] != 0)
                j += answer[j]; // answer 就是存放下一个最高离当前有几天，那么我们用当前下标j+answer[j]就是下一个最高气温

            if (j < n && temperatures[j] > temperatures[i])
                answer[i] = j - i; // 经过上面的循环 j 走到了比当前 i 下标还高的气温，那么他们中间相差x天就等于他们下标的差
            // 如果走完(j=n-1)还没有找到大于当前i的气温，那就是当前气温就是最高的，默认用0
        }
        return answer;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[][] answer = new int[n][2]; // answer[i][x,j] 第i天下个温度最高出现在x天后，也就是第j天
        answer[n - 1] = new int[] { 0, n - 1 };
        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                answer[i][0] = 1;
                answer[i][1] = i + 1;
            } else if (temperatures[i] > temperatures[i + 1]) {
                int countDay = 0;
                int nextDay = i + 1;
                while (nextDay < n) {
                    if (temperatures[nextDay] > temperatures[i]) {
                        countDay++;
                        break;
                    } else if (answer[nextDay][0] == 0) {
                        // 代表第 i+j 天 就是后面最大的温度, 而当前 i 的温度比他还大，则第i天就是目前最大的温度
                        countDay = 0;
                        nextDay = i;
                        break;
                    }

                    // temperatures[i] > temperatures[nextDay]
                    countDay += answer[nextDay][0];
                    nextDay = answer[nextDay][1];
                }
                answer[i][0] = countDay;
                answer[i][1] = nextDay;
            } else { // temperatures[i] = temperatures[i + 1]
                answer[i][0] = answer[i + 1][0] == 0 ? 0 : answer[i + 1][0] + 1;
                answer[i][1] = answer[i + 1][1] == i + 1 ? i : answer[i + 1][1];
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = answer[i][0];
        }

        return res;
    }
}
