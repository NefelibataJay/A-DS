package classical_150.java.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    public static void main(String[] args) {
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Solution106 solution = new Solution106();
        TreeNode res = solution.buildTree1(inorder, postorder);
        System.out.println("ok");
    }

    private Map<Integer, Integer> indexMap; // key 节点的值 value 该节点在 inorder中的下标

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ] inorder
        // [ [左子树的中序遍历结果], [右子树的中序遍历结果] , 根节点] postorder

        int n = postorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            indexMap.put(inorder[i], i); // 记录该节点在 中序遍历中的下标
        // 每次遍历定位 当前子树的下标区间
        return myBuildTree(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] postorder, int[] inorder, int postorder_left, int postorder_right,
            int inorder_left, int inorder_right) {
        if (postorder_left > postorder_right) {
            return null;
        }

        int postorder_root = postorder_right;
        int inorder_root = indexMap.get(postorder[postorder_root]);

        TreeNode root = new TreeNode(postorder[postorder_root]);
        int size_left_subtree = inorder_root - inorder_left;

        root.left = myBuildTree(postorder, inorder, postorder_left, postorder_left + size_left_subtree - 1,
                inorder_left, inorder_root - 1);

        root.right = myBuildTree(postorder, inorder, postorder_left + size_left_subtree, postorder_right - 1,
                inorder_root + 1, inorder_right);

        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return process(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode process(int[] post, int[] in, int postorder_left, int postorder_right,
            int inorder_left, int inorder_right) { // stop 就是中序父节点的值，
        if (postorder_left > postorder_right || inorder_left > inorder_right) {
            return null;
        }

        TreeNode root = new TreeNode(post[postorder_right]);
        int indexIn = inorder_right;

        while (in[indexIn] != post[postorder_right]) {
            indexIn--; // 从右区间开始，一直递减找到根节点
        }

        // indexIn - inorder_left 就是左子树的大小
        int left_subtree_size = postorder_left + indexIn - inorder_left;

        root.left = process(post, in, postorder_left, left_subtree_size - 1, inorder_left, indexIn - 1);

        root.right = process(post, in, left_subtree_size, postorder_right - 1, indexIn + 1, inorder_right);

        return root;
    }
}
