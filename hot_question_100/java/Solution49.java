package hot_question_100.java;

import java.util.*;

public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = solution49.groupAnagrams(strs);
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,  List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
