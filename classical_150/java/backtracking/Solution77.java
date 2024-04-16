package classical_150.java.backtracking;

import java.util.*;

public class Solution77 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k)
            return res;
        Deque<Integer> stack = new LinkedList<>();
        backtrack(n, k, 1, stack, res); // [1, ..., n]
        return res;
    }

    // 就像一个栈一样，每次插入最后的元素，保存，然后删除，插入新元素
    public void backtrack(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            // path 的长度等于 k
            res.add(new ArrayList<>(path));
            return;
        }

        // [begin, ..., n]
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) { // 搜索起点的上界 = n - (k - path.size()) + 1
            path.addLast(i); // 向路径内添加元素
            backtrack(n, k, begin + 1, path, res); // [begin+1, ..., n]
            path.removeLast();
        }
    }
    /*
     * 过程 n = 5, k = 3
     * 递归之前 => [1]
     * 递归之前 => [1, 2]
     * 递归之前 => [1, 2, 3]
     * 递归之后 => [1, 2]
     * 递归之前 => [1, 2, 4]
     * 递归之后 => [1, 2]
     * 递归之前 => [1, 2, 5]
     * 递归之后 => [1, 2]
     * 递归之后 => [1]
     * 递归之前 => [1, 3]
     * 递归之前 => [1, 3, 4]
     * 递归之后 => [1, 3]
     * 递归之前 => [1, 3, 5]
     * 递归之后 => [1, 3]
     * 递归之后 => [1]
     * 递归之前 => [1, 4]
     * 递归之前 => [1, 4, 5]
     * 递归之后 => [1, 4]
     * 递归之后 => [1]
     * 递归之前 => [1, 5]
     * 递归之后 => [1]
     * 递归之后 => []
     * 递归之前 => [2]
     * 递归之前 => [2, 3]
     * 递归之前 => [2, 3, 4]
     * 递归之后 => [2, 3]
     * 递归之前 => [2, 3, 5]
     * 递归之后 => [2, 3]
     * 递归之后 => [2]
     * 递归之前 => [2, 4]
     * 递归之前 => [2, 4, 5]
     * 递归之后 => [2, 4]
     * 递归之后 => [2]
     * 递归之前 => [2, 5]
     * 递归之后 => [2]
     * 递归之后 => []
     * 递归之前 => [3]
     * 递归之前 => [3, 4]
     * 递归之前 => [3, 4, 5]
     * 递归之后 => [3, 4]
     * 递归之后 => [3]
     * 递归之前 => [3, 5]
     * 递归之后 => [3]
     * 递归之后 => []
     * 递归之前 => [4]
     * 递归之前 => [4, 5]
     * 递归之后 => [4]
     * 递归之后 => []
     * 递归之前 => [5]
     * 递归之后 => []
     * [[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 3, 4], [1, 3, 5], [1, 4, 5], [2, 3, 4],
     * [2, 3, 5], [2, 4, 5], [3, 4, 5]]
     */

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine1(int n, int k) {
        dfs(n, k);
        return ans;
    }

    public void dfs(int u, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = u; i >= k; --i) {
            list.add(i);
            dfs(i - 1, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
