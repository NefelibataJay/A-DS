package classical_150.java.bitOperation;

public class Solution190 {
    public static void main(String[] args) {
        Solution190 solution = new Solution190();
        System.out.println(solution.reverseBits(-3));
    }

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public int reverseBitsJDK(int n) {
        // 这就是JAVA
        return Integer.reverse(n);
    }
}
