package classical_150.java.stack;

import java.util.ArrayDeque;

public class Solution71 {
    public static void main(String[] args) {
        String path = "/../";
        Solution71 solution = new Solution71();
        System.out.println(solution.simplifyPath(path));

    }

    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String res = "";
        String[] split = path.split("/");
        // 会有以下几种情况
        // 空字符串 ""
        // "."
        // ".."
        // 正常文件名 "file"

        for (String s : split) {
            if (s.equals(".") || s.isEmpty())
                continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(s);
        }

        for (String d : stack)
            res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }
}
