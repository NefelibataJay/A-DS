package daybyday.java;

public class Solution3133 {
    // 数组最后一个元素的最小值
    public static void main(String[] args) {
        // System.out.println(2 & 5 & 6);
        Solution3133 solution3133 = new Solution3133();
        System.out.println(solution3133.minEnd(3, 9));
    }

    public long minEnd(int n, int x) {
        long ans = x;
        int m = n - 1;
        for (long i = 1, offset = 0; i <= m; i <<= 1) { // i 每次都会左移一位
            while ((ans & (i << offset)) > 0) // 表示当前该位为1， 比如 9 对应的 1001， 第一位就会有1，则offset
                                              // 偏置就++；offset就是当前i指向的第几位后的ans连续1的个数
                offset++;
            ans |= (m & i) << offset;
        }
        Long.numberOfLeadingZeros(n); // 返回二进制前面的零个数
        return ans;
    }
}
