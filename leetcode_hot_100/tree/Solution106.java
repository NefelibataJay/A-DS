package leetcode_hot_100.tree;

import java.util.HashMap;

public class Solution106 {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inorderMap.get(root.val);
        int left_size = inIndex-inStart;

        root.left = build(preorder, inorder, preStart+1, preStart+left_size, inStart,inIndex-1);
        root.right = build(preorder, inorder, preStart+left_size+1, preEnd, inIndex+1, inEnd);
        return root;
    }
}
