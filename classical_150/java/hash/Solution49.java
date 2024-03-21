package classical_150.java.hash;

import java.util.*;

/*
 * @author lawrence
 */
public class Solution49 {
    public static void main(String[] args) {
        String[] strs = {""};
        Solution49 solution49 = new Solution49();
        List<List<String>> res = solution49.groupAnagrams(strs);
        System.out.println(res);
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List <String>> map = new HashMap<>();

        for (String str : strs) {
            // 将当前字符串 转换为字符数组重新排序，
            // 异位词 经过重新排序后得到的字符串都是一样的
            char[] charArray = str.toCharArray();


            Arrays.sort(charArray);
            String curString = new String(charArray);

            List<String> list = map.getOrDefault(curString, new ArrayList<String>());
            list.add(str);
            map.put(curString, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
