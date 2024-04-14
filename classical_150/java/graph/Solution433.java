package classical_150.java.graph;

import java.util.*;

public class Solution433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 0;
        Set<String> visited = new HashSet<String>();
        Set<String> cnt = new HashSet<String>();
        char[] keys = { 'A', 'C', 'G', 'T' };

        for (String s : bank)
            cnt.add(s);
        if (!cnt.contains(endGene))
            return -1; // 不包含

        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(startGene);
        visited.add(startGene);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int qs = queue.size(); // 当前队列中所有元素是经过step步数后产生的序列
            for (int i = 0; i < qs; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) { // 循环当前序列的每个字符
                    for (int k = 0; k < 4; k++) { // 循环当前字符替换为另外的字符
                        if (keys[k] == curr.charAt(j))
                            continue;

                        StringBuffer sb = new StringBuffer(curr);
                        sb.setCharAt(j, keys[k]);
                        String newStr = sb.toString();

                        if (cnt.contains(newStr) && !visited.contains(newStr)) {
                            // 只有在cnt中包含且没有被访问过的元素才能入队
                            if (newStr.equals(endGene))
                                return step;
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int minMutation1(String startGene, String endGene, String[] bank) {
        int m = startGene.length();
        int n = bank.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int endIndex = -1;
        for (int i = 0; i < n; i++) {
            if (endGene.equals(bank[i])) {
                endIndex = i;
            }
            for (int j = i + 1; j < n; j++) {
                int mutations = 0;
                for (int k = 0; k < m; k++) {
                    if (bank[i].charAt(k) != bank[j].charAt(k)) {
                        mutations++;
                    }
                    if (mutations > 1) {
                        break;
                    }
                }
                if (mutations == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        if (endIndex == -1) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[n];
        int step = 1;
        for (int i = 0; i < n; i++) {
            int mutations = 0;
            for (int k = 0; k < m; k++) {
                if (startGene.charAt(k) != bank[i].charAt(k)) {
                    mutations++;
                }
                if (mutations > 1) {
                    break;
                }
            }
            if (mutations == 1) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int curr = queue.poll();
                if (curr == endIndex) {
                    return step;
                }
                for (int next : adj[curr]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

}
