package classical_150.java.stack;

import java.util.*;

public class Solution224 {
    public static void main(String[] args) {
        String s = "-(-11 + 2)";
        Solution224 solution = new Solution224();
        System.out.println(solution.calculate1(s));
    }

    public int calculate1(String s) {
        s = s.replaceAll(" ", ""); // 处理所有的空格
        Deque<Integer> numStack = new ArrayDeque<>(); // 存放所有的数字
        Deque<String> symbolStack = new ArrayDeque<>(); // 存放所有的符号 + - (

        // 为了防止第一个数为负数，先往 nums 加个 0
        numStack.push(0);
        // 为防止 () 内出现的首个字符为运算符，将所有的空格去掉，并将 (- 替换为 (0-，(+ 替换为
        // (0+（当然也可以不进行这样的预处理，将这个处理逻辑放到循环里去做）

        for (int i = 0; i < s.length(); i++) {
            String curStr = s.charAt(i) + "";
            if (curStr.equals("("))
                symbolStack.push(s.charAt(i) + "");
            else if (s.charAt(i) == ')') {
                // 计算到最近一个左括号为止
                while (!symbolStack.isEmpty()) {
                    if (!symbolStack.peek().equals("("))
                        calculatePart(numStack, symbolStack); // 计算括号内的
                    else {
                        symbolStack.pop(); // symbolStack 为 ( 时 ，代表当前括号已经计算完毕，结束循环
                        break;
                    }
                }
            } else if (curStr.equals("+") || curStr.equals("-")) {
                // 在放入之前先把栈内可以算的都算掉，
                if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                    // i>0 避免第一个符号为 “-” 防止数组越界
                    numStack.push(0); // 防止 () 内出现的首个字符为运算符， 将 (- 替换为 (0-，(+ 替换为(0+
                }
                // 有一个新操作要入栈时，先把栈内可以算的都算了
                while (!symbolStack.isEmpty() && !symbolStack.peek().equals("("))
                    calculatePart(numStack, symbolStack);
                symbolStack.push(curStr);
            } else { // 数字
                int cur_num = 0;
                int j = i;
                // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                while (j < s.length() && Character.isDigit(s.charAt(j)))
                    // 这里cur_num * 10 是为了处理大于等于10以上数字
                    // 我们按照列表下标读取这个s字符串的时候， 21 会先读取 2 再读取 1 ， 所以我们 要先让之前的 2*10然后再 + 1 = 21。
                    // 其实这一步就是循环找到一个连续的数字，只要有连续的数字一定大于等于10
                    cur_num = cur_num * 10 + (s.charAt(j++) - '0'); // (s.charAt(i++) - '0') 计算当前数字字符的实际值
                // 注意上面的计算一定要有括号，否则有可能会溢出
                numStack.push(cur_num);
                i = j - 1; // 此时的j指向的一定是 一个非数字符号（连续数字的下一个位置） 所以我们要跳过这个连续的数字， 直接让i=j-1,此次循环结束后又会自动i++
            }

        }

        while (!symbolStack.isEmpty())
            calculatePart(numStack, symbolStack);

        return numStack.pop();
    }

    public void calculatePart(Deque<Integer> numStack, Deque<String> symbolStack) {
        if (numStack.size() < 2 || symbolStack.isEmpty())
            // numStack.size() < 2 无法满足两个数字计算的条件 symbolStack.isEmpty() 没有符号可以计算
            return;
        int b = numStack.pop();
        int a = numStack.pop();
        String op = symbolStack.pop();
        numStack.push(op == "+" ? a + b : a - b);
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1; // 用于标志当前位置的元素 是否应该是负的， 如果当前值前面有负号，或者这个括号前有负号 sign = -1

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else { // 读取到数字的情况
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) { // 向后一直读取数字
                    num = num * 10 + s.charAt(i) - '0'; // s.charAt(i) - '0'为当前字符的具体数字值
                    i++;
                }
                ret += sign * num; // 累加结果
            }
        }
        return ret;
    }
}
