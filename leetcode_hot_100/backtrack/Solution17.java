package leetcode_hot_100.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution17 {
    // 电话号码的字母组合

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        solution17.letterCombinations("23");
    }

    HashMap<Character, String> map = new HashMap<>();

    public void initMap() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    List<String> res;

    public List<String> letterCombinations(String digits) {
        initMap();
        res = new ArrayList<String>();

        backTrack(digits, 0, new StringBuilder());
        return res;
    }

    public void backTrack(String digits, int index, StringBuilder sb) {
        if (sb.length() >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        String curStr = map.get(digits.charAt(index));

        for (int i = 0; i < curStr.length(); i++) {
            sb.append(curStr.charAt(i));
            backTrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
