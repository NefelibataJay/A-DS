package classical_150.java.hash;

import java.util.*;

public class Solution290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        Solution290 solution290 = new Solution290();
        System.out.println(solution290.wordPattern1(pattern,s));

    }

    public boolean wordPattern(String pattern, String s){
        String[] strArr = s.split(" ");

        if (strArr.length != pattern.length() || pattern.isEmpty()) return false;

        Map<String, Character> countSMap = new HashMap<>();
        Map<Character, String> countTMap = new HashMap<>();

        for (int i=0; i<pattern.length(); i++){
            char pc = pattern.charAt(i);
            String si = strArr[i];

            countSMap.put(si, countSMap.getOrDefault(si, pc));
            countTMap.put(pc, countTMap.getOrDefault(pc, si));

            if (!countSMap.get(si).equals(pc) || !countTMap.get(pc).equals(si))
                return false;
        }

        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length!=pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(split[i])) {
                    // 判断对应关系是否不对
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), split[i]);
                if (!set.add(split[i])) {
                    // 判断是否重复
                    return false;
                }
            }
        }
        return true;
    }

}
