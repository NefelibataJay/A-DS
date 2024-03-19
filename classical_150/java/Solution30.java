package classical_150.java;

import java.util.*;

public class Solution30 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please input the string and words:");
//        String s = scanner.nextLine();
//        System.out.println("Please input the words:");
//        String[] words = scanner.nextLine().split(",");
        String s = "awordgoodbestwordb";
        String[] words = {"word","good","best","word"};
        Solution30 solution = new Solution30();
        List<Integer> res = solution.findSubstring1(s, words);

        for (int i: res){
            System.out.println(i);
        }
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return res;

        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();  // 一个单词的长度
        int word_num = words.length;  // 单词的个数
        int all_len = one_word * word_num;   // 目标字符串的长度

        // 统计words中每个单词的个数, 克服了 words 中有重复的单词的问题
        // 这样我们可以要求当前截取的字符串必需满足 words 中每个单词出现的次数。
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < one_word; i++) {
            // i 表示偏移量，因为我们要从每一个单词的位置开始，然后分别遍历
            // 为什么i只需要遍历到one_word-1呢？ 因为我们要按位置遍历每个长度，然后分别遍历
            // 比如 s="abfoobar", words=["foo", "bar"],
            // 当i=0时, 我们按照顺序遍历的单词 "abf", "oob", 当i=1时, 我们按照顺序遍历的单词 "bfo", "oba"，当i=2时, 我们按照顺序遍历的单词 "foo", "bar"
            // left和right分别表示窗口的左右指针，count用来统计当前截取的字符串中单词的个数
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();  // 临时map，用来统计当前截取的字符串中每个单词的个数
            while (right + one_word <= s.length()) { // 右指针每次移动一个单词的长度
                // 取出一个单词
                String w = s.substring(right, right + one_word);
                // 将取出的单词放入临时map中，并且统计个数，克服了 s 中的重复子串。
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                // 右指针右移一个单词的长度
                right += one_word;
                count++; // 统计当前截取的字符串中单词的个数
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    // 如果当前tmp_map中的 该单词 出现的次数大于map中的 该单词 出现的次数
                    // 说明当前截取的字符串中 该单词 出现的次数大于words中 该单词 出现的次数
                    // 所以需要右移左指针，直到tmp_map中的 该单词 出现的次数等于map中的 该单词 出现的次数

                    String t_w = s.substring(left, left + one_word);  // 取出最前面的一个单词
                    count--;  // 左指针右移一个单词的长度，所以count减一
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);  // 从tmp_map中去掉一个最前面的单词
                    left += one_word;  // 左指针右移一个单词的长度
                }
                if (count == word_num) res.add(left);  // 当前截取的字符串中包含了所有的words,且包含了重复的字符串 记录下左指针的位置。
            }
        }
        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // 这种方法在 words 中有重复的时候计算错误
        // s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
        // 输出：[8]
        // 预期：[]

        int targetLen = words[0].length() * words.length;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<=s.length()-targetLen; i++){
            String temp = s.substring(i, i+targetLen);  // 从i开始，长度为targetLen的字符串
            boolean flag = true;  // 标志位，若为false 代表 当前的temp子串中不包含所有的words
            for (String word: words){
                if (!temp.contains(word)){
                    flag = false;  // 当前的temp子串中不包含所有的words
                    break;
                }else temp.replace(word, "");
                // 从temp中去掉word, 可以有效防止 s 中的重复子串 但是仍然无法应对 words 中的重复子串
            }
            if (flag) res.add(i);  // 当前的temp子串中包含所有的words
        }
        return res;
    }
}
