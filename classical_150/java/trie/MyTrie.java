package classical_150.java.trie;

import java.util.*;

public class MyTrie {
    class Node {
        public char value;
        public List<Node> list;

        public boolean isLast;

        public Node() {
            list = new ArrayList<>();
        }

        public Node(char val) {
            value = val;
            list = new ArrayList<>();
        }

        public Node(char val, List<Node> _list) {
            value = val;
            list = _list;
        }
    }

    Node root;

    public MyTrie() {
        root = new Node();
    }

    public void insert(String word) {
        char[] charArr = word.toCharArray();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        int currIndex = 0;
        while (!stack.isEmpty() && currIndex <= charArr.length) {
            Node node = stack.pop();
            if (currIndex == charArr.length) {
                node.isLast = true;
                break;
            }
            for (int i = 0; i < node.list.size(); i++) {
                if (charArr[currIndex] == node.list.get(i).value) {
                    stack.push(node.list.get(i));
                    currIndex++;
                    break;
                }
            }
            if (stack.isEmpty()) {
                // 插入新节点
                node.list.add(new Node(charArr[currIndex++]));
                stack.push(node.list.get(node.list.size() - 1));
            }
        }
        System.out.println("intsert done");
    }

    public boolean search(String word) {
        // 深度优先查找
        char[] charArr = word.toCharArray();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        int currIndex = 0;
        while (!stack.isEmpty() && currIndex <= charArr.length) {
            Node node = stack.pop();
            if (currIndex == charArr.length && node.isLast)
                return true;
            else if (currIndex == charArr.length)
                return false;
            for (int i = 0; i < node.list.size(); i++) {
                if (charArr[currIndex] == node.list.get(i).value) {
                    stack.push(node.list.get(i));
                    currIndex++;
                    break;
                }
            }
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        // 广度优先查找
        char[] charArr = prefix.toCharArray();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int currIndex = 0;
        while (!queue.isEmpty() && currIndex <= charArr.length) {
            Node node = queue.poll();
            if (currIndex == charArr.length)
                return true;
            for (int i = 0; i < node.list.size(); i++) {
                if (charArr[currIndex] == node.list.get(i).value) {
                    queue.offer(node.list.get(i));
                    currIndex++;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        // System.out.println(trie.search("apple"));
        // System.out.println(trie.search("app"));
        // System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
