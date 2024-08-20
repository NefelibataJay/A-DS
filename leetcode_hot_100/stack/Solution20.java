package leetcode_hot_100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        solution20.isValid("(())");
    }

    public boolean isValid(String s) {
        Deque<Character> que = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                que.push(c);
            else {
                if (que.size() == 0)
                    return false;
                char c2 = que.pop();
                if ((c == ')' && c2 != '(') || (c == ']' && c2 != '[') || (c == '}' && c2 != '{'))
                    return false;
            }
        }

        return que.size() == 0;
    }
}
