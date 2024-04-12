package classical_150.java.graph;

public class UnionFind {
    int[] parent; // 保存每个节点对应的

    // 这里的祖先可以看作一个指针
    // 比如 1的祖先是3 就是 1 -> 3
    // 1的祖先是3， 3 的祖先初始是其自己

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 在初始的时候，每个节点的父节点都是其本身
        }
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) // 已经是同一个祖先，则不需要合并
            return;
        parent[xRoot] = yRoot; // 将x的祖先指向y的祖先
    }

    public int find(int x) {
        if (parent[x] != x) {
            int orgin = parent[x]; // 记录当前父节点
            parent[x] = find(parent[x]); // 递归寻找祖先节点
            // 处理 原来的祖先
            return parent[x];
        }
        // 某个节点的祖先是自己时，则意味着该节点就是本次递归最后的祖先节点
        return parent[x];
    }
}