package classical_150.java.math;

public class Solution68 {
    public int mySqrt(int x) {
        int low = 0, hight = x, ans = 0;
        while (low <= hight) {
            int mid = ((hight - low) >> 1) + low;
            if ((long) mid * mid > x) {
                hight = mid - 1;
            } else if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else
                return mid;
        }
        return ans;
    }
}
