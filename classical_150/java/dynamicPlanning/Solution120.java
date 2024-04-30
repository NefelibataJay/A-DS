package classical_150.java.dynamicPlanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {
    public static void main(String[] args) {
        int[][] nums = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        Solution120 solution120 = new Solution120();
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            triangle.add(new ArrayList<>());
            for (int j = 0; j < nums[i].length; j++) {
                triangle.get(i).add(nums[i][j]);
            }
        }
        System.out.println(solution120.minimumTotal1(triangle));
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        // 三角形第i层有i个元素
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i); // dp[i] = 上一层最后一个元素+当前层最后一个元素
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j); // dp[j] = 上一层的对应两个元素的最小值 + 当前层中间元素的值
            }
            dp[0] += triangle.get(i).get(0); // dp[0] = 上一层第一个元素+当前层第一个元素
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        // List<List<Integer>> dp = new ArrayList<>();
        int n = triangle.size();
        int[] dp = new int[(n * (n + 1) / 2)];

        int dpIndex = 1;
        dp[0] = triangle.get(0).get(0);

        for (int j = 1; j < n; j++) { // 从第二层开始
            for (int i = 0; i < triangle.get(j).size(); i++) {
                if (i == 0)
                    dp[dpIndex] = dp[dpIndex - j] + triangle.get(j).get(i);
                else if (i == triangle.get(j).size() - 1)
                    dp[dpIndex] = dp[dpIndex - i - 1] + triangle.get(j).get(i);
                else
                    dp[dpIndex] = Math.min(dp[dpIndex - j], dp[dpIndex - j - 1]) + triangle.get(j).get(i);

                dpIndex++;
            }
        }

        int lastN = triangle.get(n - 1).size();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < lastN; i++) {
            res = Math.min(dp[dp.length - 1 - i], res);

        }

        return res;
    }
}
