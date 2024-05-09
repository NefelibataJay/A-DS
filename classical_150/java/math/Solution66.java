package classical_150.java.math;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length, pre = 0;
        digits[n - 1]++;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + pre;
            digits[i] = sum % 10;
            pre = sum / 10;
        }

        if (pre != 0) {
            int[] res = new int[n + 1];
            System.arraycopy(digits, 0, res, 1, n);
            res[0] = pre;
            return res;
        }

        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
