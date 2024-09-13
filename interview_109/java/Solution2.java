package interview_109.java;

public class Solution2 {
    public boolean CheckPermutation(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2)
            return false;
        int[] count = new int[26];

        for (int i = 0; i < n1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}
