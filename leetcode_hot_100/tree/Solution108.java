package leetcode_hot_100.tree;

/**
 * Solution108
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        int n = nums.length;
        return getNode(nums, 0, n - 1);
    }

    public TreeNode getNode(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int mid = ((start + end) / 2); // 2
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getNode(nums, start, mid - 1);
        node.right = getNode(nums, mid + 1, end);
        return node;
    }
}