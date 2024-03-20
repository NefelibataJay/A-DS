package classical_150.java;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public static void main(String[] args) {
        String s = "abb";
        String t = "dcc";
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic1(s, t));

    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> countSMap = new HashMap<>();
        Map<Character, Character> countTMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            countSMap.put(sc, countSMap.getOrDefault(sc, tc));
            countTMap.put(tc, countTMap.getOrDefault(tc, sc));

            if (countSMap.get(sc) != tc || countTMap.get(tc) != sc)
                return false;
        }

        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (s.indexOf(a) != t.indexOf(b)) {
                // String.indexOf(String/char) 返回该字符在这个字符串中第一次出现的位置
                return false;
            }
        }
        return true;
    }
}
