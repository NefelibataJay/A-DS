package dynamicPlanning.java;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(fun2(4, 2, 4, 4));
    }

    public static int dfs(int N, int M, int P, int K) {
        if (K <= 0) {
            return M == P ? 1 : 0;
        }

        if (M == N)
            return dfs(N, M - 1, P, K - 1);
        else if (M == 1)
            return dfs(N, M + 1, P, K - 1);
        else
            return dfs(N, M - 1, P, K - 1) + dfs(N, M + 1, P, K - 1);

    }

    public static int fun1(int N, int M, int P, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs1(N, M, P, K, dp);
    }

    public static int dfs1(int N, int M, int P, int K, int[][] dp) {
        if (dp[M][K] != -1)
            return dp[M][K];// 命中缓存

        int res = 0;
        if (K <= 0)
            res = M == P ? 1 : 0;
        else if (M == N)
            res = dfs(N, M - 1, P, K - 1);
        else if (M == 1)
            res = dfs(N, M + 1, P, K - 1);
        else
            res = dfs(N, M - 1, P, K - 1) + dfs(N, M + 1, P, K - 1);
        dp[M][K] = res;
        return dp[M][K];
    }

    public static int fun2(int N, int M, int P, int K) {
        int[][] dp = new int[N + 1][K + 1];
        // 状态终止，就是走完K步，也到了终点P，就为1
        // 对应上面递归的 K==0 && M==P的时候
        dp[P][0] = 1;
        for (int step = 1; step <= K; step++) {
            dp[1][step] = dp[2][step - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][step] = dp[cur - 1][step - 1] + dp[cur + 1][step - 1];
            }
            dp[N][step] = dp[N - 1][step - 1];
        }
        return dp[M][K];
    }
}
