package classical_150.java.math;

public class Solution172 {
    public static int trailingZeroes1(int n) {
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                count++;
            }
        }
        return count;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 25;
        long result = trailingZeroes1(num);
        System.out.println("The factorial of " + num + " is: " + result);
    }
}
