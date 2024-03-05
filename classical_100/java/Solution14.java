package classical_100.java;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int minLen = getMinLen(strs);
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) return stringBuilder.toString();
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public int getMinLen(String[] strs){
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        return minLen;
    }


    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
