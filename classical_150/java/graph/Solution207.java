package classical_150.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        // 0 -> 1 , 0 -> 2 , 1 -> 3 , 2 -> 3
        Solution207 solution = new Solution207();
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }

    static class Node {// 课程结点，用来抽象为图
        Node next;// 当前结点指向的下一个结点
        int val;// 值

        public Node() {
            this.val = -1;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // 入口方法
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Node[] corses = new Node[numCourses];// 创建结点数组，充当栈，保存每个结点的前置结点
        for (int[] pre : prerequisites) {// 依次遍历图中顶点
            // 想要完成课程pre[0]，需要先完成课程pre[1]
            // 因此corses中的前后继关系为pre[1]->pre[0],表示先完成pre[1]才有pre[0]
            // 因此对于pre[0]，我们保存其所有前驱结点（入度结点，有向图指向它的结点）,这些前驱必须先遍历才能保证拓扑排序
            // 例如[1,0]表示完成1需要0.则有corses[1] = node{val = 0,next = null}.表示对于1，有一个前驱0指向它
            // 此时发现[1,2],表示完成1需要2，则有corses[1] = node{val = 2,next = node{val = 0,next =
            // null}};//表示对于1，有2和0指向它
            // 此时发现[1,3],表示完成1需要3，则有corses[1] = node{val = 3,next = node{val = 2,next =
            // node{val = 0,next = null}}};//表示对于1，有3,2,0指向它
            corses[pre[0]] = new Node(pre[1], corses[pre[0]]);
        }
        boolean[] finished = new boolean[numCourses];// 标识当前结点是否已经拓扑排序过了
        boolean[] visited = new boolean[numCourses];// 标识结点是否已经访问
        for (int i = 0; i < numCourses; i++) {// 遍历每个结点
            if (!dfs(corses, finished, visited, i)) {// 对其深度优先遍历
                return false;// 失败就返回false
            }
        }
        return true;// 成功返回true
    }

    private boolean dfs(Node[] corses, boolean[] finished, boolean[] visited, int i) {
        if (finished[i])
            return true;// 已经完成过拓扑排序，直接返回true
        if (visited[i])
            return false;// 没有完成过拓扑排序，但是又重新访问了这个结点，说明有环，无法进行拓扑排序

        visited[i] = true;// 访问该结点
        Node node = corses[i];
        while (node != null) {// 深度优先
            if (!dfs(corses, finished, visited, node.val))
                return false;// 如果拓扑失败就返回false
            node = node.next;// 深度优先
        }
        finished[i] = true;// 当前结点被拓扑排序完成，标志为true
        return true;// 返回true
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i)
            edges.add(new ArrayList<Integer>());

        int[] indegree = new int[numCourses];
        for (int[] info : prerequisites) { // [1,0] 0->1
            edges.get(info[1]).add(info[0]);
            indegree[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int subCourse : edges.get(course)) {
                indegree[subCourse]--;
                if (indegree[subCourse] == 0)
                    queue.offer(subCourse);
            }
        }

        return count == numCourses;
    }

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i)
            edges.add(new ArrayList<Integer>());

        visited = new int[numCourses];

        for (int[] info : prerequisites)
            // 子课程就是学完当前课以后可以学的课程
            edges.get(info[1]).add(info[0]); // 记录每一个课程的子课程

        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0)
                dfs(i);

        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1; // 搜索课程
        for (int v : edges.get(u)) {
            // 访问当前节点的子节点（子课程）
            if (visited[v] == 0) {
                // 子课程没有被搜索过
                dfs(v);
                if (!valid)
                    return;
            } else if (visited[v] == 1) {
                // 又访问到了正在搜索的课程，意味着有循环，则直接退出
                valid = false;
                return;
            }
        }
        visited[u] = 2; // 课程已经完成
    }
}
