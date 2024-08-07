package leetcode_hot_100.tree;

public class Solution124 {
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if (node == null)
            return 0;

        int leftValue = Math.max(maxGain(node.left), 0);
        int rightValue = Math.max(maxGain(node.right), 0);

        int cur = node.val + leftValue + rightValue;

        maxSum = Math.max(maxSum, cur);
        return Math.max(rightValue, leftValue) + node.val;
    }
}
