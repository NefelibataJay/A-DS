package classical_150.java.arrwithstr;

import java.util.HashMap;

public class Solution121 {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        Solution121 solution = new Solution121();
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int maxProfit = 0, minProfit = prices[0];
        // minProfit 一直在记录着最小的价格
        // 如果当前股票价格低于之前的价格，一定是先记录最小价格，而不会取计算最大收益。因为收益明显是<=0的
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minProfit)
                minProfit = prices[i];
            else if (prices[i] - minProfit > maxProfit)
                maxProfit = prices[i] - minProfit;
        }
        return maxProfit;
    }

}
