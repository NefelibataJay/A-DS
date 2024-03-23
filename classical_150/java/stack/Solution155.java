package classical_150.java.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution155 {
    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);

        System.out.println(minStack.getMin()); // 返回 -2.
        System.out.println(minStack.top()); // 返回 -1.
        minStack.pop();
        System.out.println(minStack.getMin()); // 返回 -2.

    }

}

class MinStack {
    ArrayList<Integer> sortList; // 按照大小顺序存放每个元素的位置
    ArrayList<Integer> dataStack; // 存放元素

    public MinStack() {
        sortList = new ArrayList<>(); // 2, 0, 1
        dataStack = new ArrayList<>(); // -2, 0, -3
    }

    public void push(int val) {
        if (dataStack.size() == 0) {
            dataStack.add(val);
            sortList.add(0);
            return;
        }

        if (val < dataStack.get(sortList.get(0)))
            sortList.add(0, dataStack.size());
        else if (val > dataStack.get(sortList.get(sortList.size() - 1)))
            sortList.add(dataStack.size());
        else {
            // 即不是最大也不是最小
            for (int i = 1; i < sortList.size(); i++) {
                int index = sortList.get(i);
                if (dataStack.get(index) > val) {
                    sortList.add(i, dataStack.size());
                    break;
                }
            }
        }

        dataStack.add(val);
    }

    public void pop() {
        dataStack.remove(dataStack.size() - 1);
        for (int i = 0; i < sortList.size(); i++) {
            if (sortList.get(i) == dataStack.size())
                sortList.remove(i);
        }
    }

    public int top() {
        return dataStack.get(dataStack.size() - 1);
    }

    public int getMin() {
        return dataStack.get(sortList.get(0));
    }
}

class MinStack1 {
    ArrayDeque<Integer> minDataStack; // 按照大小顺序存放每个元素的位置
    ArrayDeque<Integer> dataStack; // 存放元素

    public MinStack1() {
        minDataStack = new ArrayDeque<>(); // 2, 0, 1
        dataStack = new ArrayDeque<>(); // -2, 0, -3
    }

    public void push(int val) {
        if (dataStack.size() == 0) {
            dataStack.push(val);
            minDataStack.push(val);
        } else {
            minDataStack.push(Math.min(minDataStack.peek(), val));
            dataStack.push(val);
        }

    }

    public void pop() {
        dataStack.pop();
        minDataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minDataStack.peek();
    }
}