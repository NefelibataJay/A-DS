package classical_150.java.stack;

import java.util.ArrayDeque;

public class Solution20 {
    public static void main(String[] args) {
        String s = "(){}}{";
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid(s));
    }

    public boolean isValid(String s) {
        ArrayDeque<Character> que = new ArrayDeque<>();
        que.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}' || c == ']') {
                if (que.size() == 0 || c - 2 != que.pop())
                    return false;
            } else if (c == ')') {
                if (que.size() == 0 || c - 1 != que.pop())
                    return false;
            } else
                que.push(c);
        }
        return que.size() == 0;
    }
}
