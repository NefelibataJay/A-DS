package classical_150.java.graph;

import java.util.*;

public class Solution133 {
    public static void main(String[] args) {

    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph2(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            map.get(node).neighbors.add(dfs(neighbor));
        }
        return clone;
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Map<Node, Node> nodeMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        // 克隆第一个节点并存储到哈希表中
        queue.offer(node);
        nodeMap.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node neighbor : curNode.neighbors) {
                if (!nodeMap.containsKey(curNode)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    nodeMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // 将邻居节点加入队列中
                    queue.offer(neighbor);
                }
                // 将当前新的邻居节点放入对应新节点的邻居中
                nodeMap.get(curNode).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return nodeMap.get(node);
    }

    Map<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraph1(Node node) {
        if (node == null)
            return node;

        if (nodeMap.containsKey(node))
            return nodeMap.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, cloneNode);

        for (Node neighbor : node.neighbors)
            cloneNode.neighbors.add(cloneGraph(neighbor));

        return cloneNode;
    }
}
