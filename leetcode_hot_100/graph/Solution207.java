package leetcode_hot_100.graph;

import java.util.*;

public class Solution207 {
    class GraphNode {
        int inNum = 0;
        int value;
        List<GraphNode> adj = new ArrayList<>();
        public boolean visited = false;

        public GraphNode(int val) {
            value = val;
        }

        public void addNode(GraphNode pre) {
            adj.add(pre);
        }

        public void addInNum() {
            inNum++;
        }

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if (n < 2)
            return true;

        Map<Integer, GraphNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];

            GraphNode curNode = map.getOrDefault(cur, new GraphNode(cur));
            GraphNode preNode = map.getOrDefault(pre, new GraphNode(pre));

            preNode.addNode(curNode);
            curNode.addInNum();

            if (!map.containsKey(cur))
                map.put(cur, curNode);
            if (!map.containsKey(pre))
                map.put(pre, preNode);
        }

        Queue<GraphNode> que = new ArrayDeque<>();

        for (GraphNode node : map.values()) {
            if (node.inNum == 0) {
                que.offer(node);
                map.remove(node.value);
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0 && que.isEmpty()) {
                GraphNode curNode = que.poll();
                for (int i = 0; i < curNode.adj.size(); i++) {
                    GraphNode node = curNode.adj.get(i);
                    node.inNum--;
                    if (!node.visited && node.inNum == 0) {
                        que.add(node);
                        node.visited = true;
                        map.remove(node.value);
                    }
                }
            }
        }

        return map.isEmpty();
    }

    List<List<Integer>> edges = new ArrayList<>();
    int[] indeg;

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            edges.add(new ArrayList<>());

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)
                que.offer(i);
        }

        int visited = 0;
        while (!que.isEmpty()) {
            visited++;
            int cur = que.poll();
            for (int v : edges.get(cur)) {
                indeg[v]--;
                if (indeg[v] == 0)
                    que.offer(v);
            }
        }

        return visited == numCourses;
    }
}
