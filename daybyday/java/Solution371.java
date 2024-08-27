package daybyday.java;

public class Solution371 {
    public static void main(String[] args) {
        getSum(2, 3);
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // 所有共同为1的位数 进位
            a = a ^ b; // 只有 1 | 0 为 1 , 00 和11 都是 0
            b = carry;
        }
        return a;
    }
}
