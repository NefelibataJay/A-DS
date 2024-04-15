package classical_150.java.graph;

import java.lang.reflect.Array;
import java.util.*;

public class Solution127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int m = endWord.length();

        ArrayList<Integer>[] words = new ArrayList[n + 1]; // 记录邻居
        for (int i = 0; i < n; i++)
            words[i] = new ArrayList<Integer>(); // 记录在wordList[i] 这个单词的邻居下标

        int endIndex = -1; // 检查最后的结果是否在wordlist中
        for (int i = 0; i < n; i++) {
            String curr = wordList.get(i);
            if (curr.equals(endWord))
                endIndex = i; // 检查最后的结果是否在wordlist中
            for (int j = i + 1; j < n; j++) {
                String next = wordList.get(j);
                int count = 0; // 记录不同的字母数量
                for (int k = 0; k < m; k++) {
                    if (curr.charAt(k) != next.charAt(k))
                        count++;
                    if (count > 1)
                        break;
                }
                if (count == 1) {
                    words[i].add(j);
                    words[j].add(i);
                }
            }
        }
        if (endIndex == -1)
            return 0; // 最后的结果不在wordlist中

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // 找到和beginWord相差一个字符的字
        for (int i = 0; i < n; i++) {
            String curr = wordList.get(i);
            int count = 0; // 记录不同的字母数量
            for (int k = 0; k < m; k++) {
                if (curr.charAt(k) != beginWord.charAt(k))
                    count++;
                if (count > 1)
                    break;
            }
            if (count == 1) {
                queue.offer(i); // 入队
                visited[i] = true;
            }
        }

        int step = 1; // 现在队列已经是经过一步的元素了
        while (!queue.isEmpty()) {
            step++;
            int qs = queue.size(); // 每个大循环内，队列存放的都是当前步数的所有单词
            for (int i = 0; i < qs; i++) {
                int nextIndex = queue.poll();
                if (nextIndex == endIndex)
                    return step;
                for (int j : words[nextIndex]) {
                    if (visited[j]) {
                        continue;
                    }
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
        return 0;
    }

    Map<String, List<String>> edge = new HashMap<>(); // {log : [*og, l*g, lo*] }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }

        for (String word : wordList) {
            addEdge(word);
        }

        addEdge(beginWord);
        Map<String, Integer> step = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        step.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String oldWord = queue.poll();
            if (oldWord.equals(endWord)) {
                return step.get(oldWord) / 2 + 1;
            }
            for (String newWord : edge.get(oldWord)) {
                if (!step.containsKey(newWord)) {
                    step.put(newWord, step.get(oldWord) + 1);
                    queue.offer(newWord);
                }
            }
        }

        return 0;
    }

    public void addEdge(String word) {
        if (!edge.containsKey(word)) {
            edge.put(word, new ArrayList<>());
        }
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array); // *ot
            edge.get(word).add(newWord);// { hot : [*ot,]}
            if (!edge.containsKey(newWord)) {
                edge.put(newWord, new ArrayList<>());
            }
            edge.get(newWord).add(word); // { *ot : [ hot,]}
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        String begString = "hit";
        String endString = "log";
        String[] wordList = { "hot", "dot", "dog", "lot", "log" };
        Solution127 solution127 = new Solution127();
        System.out.println(solution127.ladderLength1(begString, endString, Arrays.asList(wordList)));
    }
}
