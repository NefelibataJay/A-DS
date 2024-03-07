package classical_100.java;

public class Solution392 {
    public static void main(String[] args) {
        Solution392 solution = new Solution392();
        System.out.println(solution.isSubsequence("b", "c"));

    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length() ) return false;

        if (s.isEmpty()) return true;

        int index = 0;
        for (int i = 0; i< t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }
}
