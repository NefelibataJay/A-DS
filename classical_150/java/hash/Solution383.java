package classical_150.java.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        Solution383 solution383 = new Solution383();
        System.out.println(solution383.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> countMap = new HashMap<>();

        for (Character c : magazine.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        for (Character c: ransomNote.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0)-1);
            if (countMap.get(c) < 0) return false;
        }

        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine){
        if (ransomNote.length() > magazine.length()) return false;
        int[] arr = new int[26];
        for (int i=0; i<magazine.length(); i++){
            arr[magazine.charAt(i)-'a']++;
        }

        for (int i=0; i<ransomNote.length(); i++){
            arr[ransomNote.charAt(i)-'a']--;
            if (arr[ransomNote.charAt(i)-'a']<0) return false;
        }
        return true;
    }
}
