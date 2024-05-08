package classical_150.java.bitOperation;

public class Solution201 {
    public static void main(String[] args) {
    }

    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            res++;
        }
        return left << res;
    }
}
