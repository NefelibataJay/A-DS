package daybyday.java;

public class Solution2024 {
    public static void main(String[] args) {
        Solution2024 solution2024 = new Solution2024();
        solution2024.maxConsecutiveAnswers("TTFFFFTT", 2);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxChar(answerKey, k, 'T'), maxChar(answerKey, k, 'F'));
    }

    public int maxChar(String s, int k, char ch) {
        int n = s.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += s.charAt(right) != ch ? 1 : 0; // 计算不相等的字母个数
            while (sum > k) { // 如果已经大于了可以替换的次数k
                sum -= s.charAt(left++) != ch ? 1 : 0; // 再次从前往后找到不相等的位置
            } // 此时的left 一定能保证 [left,right]里能用k次替换掉全部的不一样字符
            ans = Math.max(ans, right - left + 1); // 计算长度
        }
        return ans;
    }
}
