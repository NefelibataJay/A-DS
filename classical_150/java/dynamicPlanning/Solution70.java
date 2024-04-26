package classical_150.java.dynamicPlanning;

public class Solution70 {
    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        System.out.println(solution.climbStairs(44));
    }

    public int climbStairs1(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs(int n) {
        int prev = 1, curr = 1;
        // 为什么从 2 开始，f(2) = f(1) + f(0) = 1 + 1
        // 为什么 f(0) = 1, 我们从0出发到2两种方案一种就是一步到位 0->2 走两节，所以f(0) = 1
        for (int i = 2; i <= n; i++) {
            int next = curr + prev; // f(n) = f(n - 1) + f(n - 2)
            prev = curr; // 记录前一个值 prev 就是(n-2)
            curr = next; // 记录当前值，对于下一个位置就是(n-1)
        } // 最后i=n的时候就是我们已经到了目标台阶
        return curr;
    }
}
