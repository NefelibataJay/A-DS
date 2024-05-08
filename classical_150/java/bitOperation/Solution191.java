package classical_150.java.bitOperation;

public class Solution191 {
    public static void main(String[] args) {
        int n = 128;
        System.out.println(n / 2);
        System.out.println(n % 2);
        System.out.println(Integer.toBinaryString(n));

    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // 每次都消除末置位的1
            System.out.println(Integer.toBinaryString(n));
            System.out.println(Integer.toBinaryString(n - 1));
            n = n & n - 1;
            res++;
        }
        return res;
    }

    public int hammingWeightJDK(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                res++;
        }
        return res;
    }

    public int hammingWeight1(int n) {
        String bits = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1')
                res++;
        }
        return res;
    }
}
