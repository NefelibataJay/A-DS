package daybyday.java;

import java.util.*;

import daybyday.java.Solution1436.Node;

public class Solution1436 {
    class Node {
        String value;
        Node next;

        public Node() {

        }
    }

    public String destCity1(List<List<String>> paths) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < paths.size(); i++) {
            String start = paths.get(i).get(0);
            set.add(start);
        }

        for (int i = 0; i < paths.size(); i++) {
            String end = paths.get(i).get(1);
            if (!set.contains(end)) {
                return end;
            }
        }
        return "";
    }

    public String destCity(List<List<String>> paths) {
        Node head = new Node();
        Node pre = head;

        HashMap<String, Node> map = new HashMap<String, Node>();

        for (int i = 0; i < paths.size(); i++) {
            String start = paths.get(i).get(0);
            String end = paths.get(i).get(1);

            if (!map.containsKey(start)) {
                Node node = new Node();
                node.value = start;
                map.put(start, node);
            }
            Node startNode = map.get(start);

            if (!map.containsKey(end)) {
                Node node = new Node();
                node.value = end;
                map.put(end, node);
            }
            Node endNode = map.get(end);

            startNode.next = endNode;
        }

        for (String key : map.keySet()) {
            if (map.get(key).next == null)
                return key;
        }
        return null;
    }
}
