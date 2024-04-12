package classical_150.java.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution399 {
    public static void main(String[] args) {
        String[][] equations = { { "a", "b" }, { "b", "c" } }; // [["a","b"],["b","c"],["bc","cd"]]

        double[] values = { 2.0, 3.0 };

        String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };

        Solution399 solution = new Solution399();
        double[] res = solution.calcEquation(toList(equations), values, toList(queries));

        System.out.println(Arrays.toString(res));
    }

    public static List<List<String>> toList(String[][] strArr) {
        List<List<String>> strList = new ArrayList<>();
        for (String[] row : strArr) {
            List<String> innerList = new ArrayList<>();
            for (String str : row) {
                innerList.add(str);
            }
            strList.add(innerList);
        }
        return strList;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        // 2 * equationsSize 为了处理可能包含着 {{a,b}{c,d}} 这种情况
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i); // {a,b}
            String var1 = equation.get(0); // a
            String var2 = equation.get(1); // b
            // 利用hashmap来映射unionFind中的parent和weight的下标，比如b对应的1， 则parent[1]就是b的父亲节点
            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id); // a : 0
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id); // b : 1
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            // 获取对应下标
            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) { // 如果map中不存在这个下标，就代表这个字母没有在equations中出现过
                res[i] = -1.0d; // 结果记为-1
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n]; // parent[a] = b 表示：结点 a 的（直接）父亲结点是 b
            this.weight = new double[n]; // weight[a] 表示结点 a 到它的 直接父亲结点 的有向边的权重
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 默认每个节点的父亲节点都是自己
                weight[i] = 1.0d; // 初始权重为1.0
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x); // 找到x的父亲节点
            int rootY = find(y); // 找到y的父亲节点
            if (rootX == rootY) {
                return; // 同一个父亲节点
            }
            // x -> y
            parent[rootX] = rootY; // 不同的父亲节点时， 让y的父亲节点作为x父亲节点的父亲
            // 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x]; // 跟新x的父亲节点的权重
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) { // x的父亲节点不是自己
                int origin = parent[x];
                parent[x] = find(parent[x]); // 递归寻找根节点
                weight[x] *= weight[origin]; // 重新计算当前节点指向根节点后的权重
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) { // 根据find中递归 确认这两个节点已经指向了同一个根节点
                return weight[x] / weight[y];
            } else { // 如果不为同一个节点，这个方程可能无解
                return -1.0d;
            }
        }
    }

}
