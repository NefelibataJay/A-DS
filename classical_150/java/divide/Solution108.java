package classical_150.java.divide;

public class Solution108 {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return binarySearch(nums, 0, nums.length - 1);
    }

    public TreeNode binarySearch(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = binarySearch(nums, left, mid - 1);
        node.right = binarySearch(nums, mid + 1, right);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
