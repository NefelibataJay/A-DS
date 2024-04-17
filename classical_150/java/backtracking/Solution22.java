package classical_150.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result); // [] -> [(,(,(,(,(,(]
            current[pos] = ')'; // [(,(,(,(,(,)]
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) { // 计算 '(' 和 ')' 的数量和顺序是否一样
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        System.out.println(solution.generateParenthesis2(3).toString());
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        // open 表示需要的左括号数量， close 表示需要的右括号数量
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            System.out.println("保存 -> " + cur.toString());
            return;
        }
        if (open < max) { // 左括号已经超过了一半
            cur.append('(');
            System.out.println("open 前 -> " + cur.toString());
            backtrack(ans, cur, open + 1, close, max);
            System.out.println("open 后 -> " + cur.toString());
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) { // 右括号没有左括号的数量多
            cur.append(')');
            System.out.println("close 前 -> " + cur.toString());
            backtrack(ans, cur, open, close + 1, max);
            System.out.println("close 后 -> " + cur.toString());
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    /*
     * n = 3
     * open 前 -> (
     * open 前 -> ((
     * open 前 -> (((
     * close 前 -> ((()
     * close 前 -> ((())
     * close 前 -> ((()))
     * 保存 -> ((()))
     * close 后 -> ((()))
     * close 后 -> ((())
     * close 后 -> ((()
     * open 后 -> ((( 删除最后一个左括号（复位），此时 open = 3, close = 0,
     * close 前 -> (()
     * open 前 -> (()( 此时 open = 3 > n, close = 1,进入close 的循环
     * close 前 -> (()()
     * close 前 -> (()())
     * 保存 -> (()())
     * close 后 -> (()())
     * close 后 -> (()()
     * open 后 -> (()(
     * close 前 -> (())
     * open 前 -> (())(
     * close 前 -> (())()
     * 保存 -> (())()
     * close 后 -> (())()
     * open 后 -> (())(
     * close 后 -> (())
     * close 后 -> (()
     * open 后 -> ((
     * close 前 -> ()
     * open 前 -> ()(
     * open 前 -> ()((
     * close 前 -> ()(()
     * close 前 -> ()(())
     * 保存 -> ()(())
     * close 后 -> ()(())
     * close 后 -> ()(()
     * open 后 -> ()((
     * close 前 -> ()()
     * open 前 -> ()()(
     * close 前 -> ()()()
     * 保存 -> ()()()
     * close 后 -> ()()()
     * open 后 -> ()()(
     * close 后 -> ()()
     * open 后 -> ()(
     * close 后 -> ()
     * open 后 -> (
     */

    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis3(int n) {
        return generate(n);
    }
}
