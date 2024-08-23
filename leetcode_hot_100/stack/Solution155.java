package leetcode_hot_100.stack;

import java.util.*;

public class Solution155 {
    // 最小栈
    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> miniStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            miniStack = new ArrayDeque<>();
            miniStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            if (val <= miniStack.peek())
                miniStack.push(val);
            else
                miniStack.push(miniStack.peek());
        }

        public void pop() {
            stack.pop();
            miniStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return miniStack.peek();
        }
    }
}
