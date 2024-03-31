package classical_150.java.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    public static void main(String[] args) {
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Solution105 solution = new Solution105();
        solution.buildTree(preorder, inorder);

    }

    private Map<Integer, Integer> indexMap; // key 节点的值 value 该节点在 inorder中的下标

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ] preorder
        // [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ] inorder
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            indexMap.put(inorder[i], i);
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left,
            int inorder_right) {
        // preorder_left -> 左区间 preorder_left -> 右区间
        // inorder_left -> 左区间 inorder_right -> 右区间
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个位置的节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点 的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目 根节点的下标位置 - 左子树的作曲奖
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        // preorder_left + 1 就是左子树的根节点位置。
        // preorder_left + size_left_subtree 就是当前左子树的最后一个节点
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left,
                inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);
        return root;
    }
}
