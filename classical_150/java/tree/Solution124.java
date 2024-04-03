package classical_150.java.tree;

public class Solution124 {
    public static void main(String[] args) {
        System.out.println(0 - 1000 > -1000);

    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int value = dfs(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewpath);

        return Math.max(leftGain, rightGain) + root.val;
    }
}
