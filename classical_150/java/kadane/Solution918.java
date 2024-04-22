package classical_150.java.kadane;

public class Solution918 {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        // 最大的环形子数组和 = max(最大子数组和，数组总和-最小子数组和)
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
