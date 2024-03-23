package classical_150.java.stack;

import java.util.*;

public class Solution150 {
    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        Solution150 solution = new Solution150();
        System.out.println(solution.evalRPN1(tokens));

    }

    public int evalRPN(String[] tokens) {
        if (tokens.length < 1)
            return 0;
        Deque<Integer> numStack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            int curS = 0;
            switch (s) {
                case "+":
                    curS = numStack.pop() + numStack.pop();
                    break;
                case "-":
                    int n1 = numStack.pop();
                    int n2 = numStack.pop();
                    curS = n2 - n1;
                    break;
                case "*":
                    curS = numStack.pop() * numStack.pop();
                    break;
                case "/":
                    n1 = numStack.pop();
                    n2 = numStack.pop();
                    curS = n2 / n1;
                    break;
                default:
                    curS = Integer.parseInt(s);
                    break;
            }
            numStack.push(curS);
        }

        return numStack.pop();
    }

    public int evalRPN1(String[] tokens) {
        index = tokens.length - 1;
        // 开始递归的从后先前一直遍历
        return getPrefix(tokens);
    }

    int index;

    public int getPrefix(String[] tokens) {
        String token = tokens[index--];
        if (token.equals("+")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 + prefix1;
        } else if (token.equals("-")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 - prefix1;
        } else if (token.equals("*")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 * prefix1;
        } else if (token.equals("/")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 / prefix1;
        } else {
            return Integer.parseInt(token);
        }
    }
}
