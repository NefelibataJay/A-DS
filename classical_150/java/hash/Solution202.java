package classical_150.java.hash;

public class Solution202 {
    public static void main(String[] args) {
        int n = 19;
        Solution202 solution202 = new Solution202();
        System.out.println(solution202.isHappy(n));
    }

    public int squareSum(int n) {
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10; //
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        };
        return slow == 1;
    }
}
