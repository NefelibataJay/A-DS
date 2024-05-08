package classical_150.java.bitOperation;

public class Solution137 {
    public static void main(String[] args) {
        // X& (~Y) 二进制求余
        Solution137 solution = new Solution137();
        int[] nums = { 2, 2, 3, 2 };
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            // X& (~Y) 二进制求余
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
