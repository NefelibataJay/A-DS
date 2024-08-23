package leetcode_hot_100.stack;

import java.util.*;

public class Solution394 {
    // 字符串解码
    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString(str));
    }

    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length();) {
            if (i < s.length() && Character.isDigit(s.charAt(i))) {
                StringBuilder cur = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    cur.append(s.charAt(i));
                    i++;
                }
                stack.push(cur.toString()); // 添加数字
            }

            if (i < s.length() && s.charAt(i) == '[') {
                stack.push(String.valueOf(s.charAt(i++)));
            }

            if (i < s.length() && Character.isLetter(s.charAt(i))) {
                StringBuilder cur = new StringBuilder();
                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    cur.append(s.charAt(i));
                    i++;
                }
                stack.push(cur.toString()); // 添加字母
            }

            if (i < s.length() && s.charAt(i) == ']') {
                List<String> list = new ArrayList<>();
                while (!stack.peek().equals("[")) {
                    list.add(stack.pop());
                }
                stack.pop();
                int k = Integer.parseInt(stack.pop());
                StringBuilder cur = new StringBuilder();
                String tempStr = getString(list);
                for (int j = 0; j < k; j++) {
                    cur.append(tempStr);
                }
                stack.push(cur.toString());
                i++;
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public String getString(List<String> list) {
        StringBuffer ret = new StringBuffer();
        for (String s : list) {
            ret.append(s);
        }
        return ret.toString();
    }
}
