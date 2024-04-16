package classical_150.java.backtracking;

import java.util.*;

public class Solution17 {
    public static void main(String[] args) {

    }

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.isEmpty())
            return combinations;
        init();
        backtrack(combinations, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i)); // combination 存储每一次取出来的结果
            backtrack(combinations, digits, index + 1, combination); // 在递归到最后一个digits 时，会把combination存入combinations中
            combination.deleteCharAt(index); // 我们删除当前这个字符，以便后面的字母存入
        }
    }

    /*
     * 过程： '23'
     * 先进入 '2' 的循环内
     * combinations : [] combination : 'a' 开始 '2' 的循环
     * combinations : [] combination : 'ad' 进入 '3'
     * combinations : ['ad'] combination : 'ad' 回溯，并删除d
     * combinations : ['ad'] combination : 'ae'
     * combinations : ['ad','ae'] combination : 'ae' 回溯，并删除e
     * combinations : ['ad','ae'] combination : 'af'
     * combinations : ['ad','ae','af'] combination : 'af' 回溯，并删除f
     * combinations : ['ad','ae','af'] combination : 'a' 回溯到 '2' 的循环内，删除a
     * combinations : ['ad','ae','af'] combination : 'b' 继续循环 '3'
     */

    public void init() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
