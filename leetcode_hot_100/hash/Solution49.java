package leetcode_hot_100.hash;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            List<String> strList = map.getOrDefault(key, new ArrayList<>());

            strList.add(str);
            map.put(key, strList);
        }

        return new ArrayList<>(map.values());
    }
}
