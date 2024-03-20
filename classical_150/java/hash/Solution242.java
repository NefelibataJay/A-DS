package classical_150.java.hash;

public class Solution242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram(s,t));

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sArr = new int[26];

        for (int i=0; i<s.length(); i++){
            sArr[s.charAt(i)-'a']++;
        }

        for (int i=0; i<t.length(); i++){
            sArr[t.charAt(i)-'a']--;
        }

        for (int j : sArr) {
            if (j != 0) return false;
        }

        return true;
    }
}
