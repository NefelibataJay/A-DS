package classical_150.java.tree;

import java.util.*;

public class Solution637 {
    List<Integer> counts = new ArrayList<Integer>();
    List<Double> sums = new ArrayList<Double>();

    public List<Double> averageOfLevels2(TreeNode root) {
        dfs(root, 0);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + node.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.set(level, 1.0 * node.val);
            counts.set(level, 1);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>(); // 记录每层的节点

        level.add(root);

        while (!level.isEmpty()) {
            int count = level.size(); // 当前层节点个数
            double sum = 0.0;
            for (int i = 0; i < count; i++) { // 循环取出 count 个节点，并累加
                TreeNode tree = level.get(0);
                sum += tree.val;
                if (tree.left != null)
                    level.add(tree.left);

                if (tree.right != null)
                    level.add(tree.right);

                level.remove(0);
            }
            list.add(sum / count); // 计算该层节点个数
        }

        return list;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, Double> avaMap = new HashMap<Integer, Double>(); // 存储每层的平均值
        Map<Integer, Integer> nodeMap = new HashMap<Integer, Integer>(); // 存储该层节点个数

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> deepQueue = new LinkedList<>();

        queue.offer(root);
        deepQueue.offer(1);

        int curDepth = 0;
        Double sum = 0.0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int depth = deepQueue.poll();
            if (node != null) {
                if (depth != curDepth) {
                    curDepth++;
                    sum = 0.0;
                }

                sum += node.val;
                nodeMap.put(depth, nodeMap.getOrDefault(depth, 0) + 1);
                Double average = sum / nodeMap.getOrDefault(depth, 1);
                avaMap.put(depth, average);

                queue.offer(node.left);
                deepQueue.offer(depth + 1);
                queue.offer(node.right);
                deepQueue.offer(depth + 1);
            }
        }

        return avaMap.values().stream().toList();
    }
}
