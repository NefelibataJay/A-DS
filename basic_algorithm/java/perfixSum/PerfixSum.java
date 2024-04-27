package basic_algorithm.java.perfixSum;

public class PerfixSum {
    /*
     * 一维前缀和
     * y[n] = y[n-1] + x[n]
     * y[n] = y[n-1] + x[x-1]
     */
    public void sum1D(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            // prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    /*
     * 二维前缀和
     * y[n,n] = y[n-1,n] + y[n,n-1] - y[n-1,n-1] + x[n,n]
     */
    public void sum2D(int[][] nums) {
        int n = nums.length;
        int[][] prefixSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + nums[i][j];
            }
        }

    }
}
