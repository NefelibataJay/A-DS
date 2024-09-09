package daybyday.java;

public class Solution1234 {
    public static void main(String[] args) {
        Solution1234 solution1234 = new Solution1234();
        System.out.println(solution1234.balancedString("WQWRQQQW"));
    }

    public int balancedString(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();

        int res = 0;
        int L = 0;
        while (L < n - 3) {
            res += countTime(cs, L, L + 3);
            L += 4;
        }

        return res;
    }

    public int countTime(char[] s, int start, int end) {
        int[] count = new int[4];
        int res = 0;
        for (int i = start; i <= end; i++) {
            if (s[i] == 'Q')
                count[0]++;
            else if (s[i] == 'W')
                count[1]++;
            else if (s[i] == 'E')
                count[2]++;
            else
                count[3]++;
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] > 1) {
                res += Math.abs(count[i] - 1);
            }
        }
        return res;
    }
}
