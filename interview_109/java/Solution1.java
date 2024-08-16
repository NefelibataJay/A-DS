package interview_109.java;

public class Solution1 {
    public boolean isUnique(String astr) {
        int n = astr.length();
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            arr[astr.charAt(i) - 'a']++;
            if (arr[astr.charAt(i) - 'a'] > 1)
                return false;
        }

        return true;
    }
}
