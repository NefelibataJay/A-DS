package classical_150.java.graph;

import java.util.*;

public class Solution210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        // 0 -> 1 , 0 -> 2 , 1 -> 3 , 2 -> 3
        Solution210 solution = new Solution210();
        int[] res = solution.findOrder(numCourses, prerequisites);
        for (int i : res)
            System.out.println(i);
    }

    // 拓扑排序1
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        // prerequisites 只记录有需要提前学习的课，没有的默认不在内部
        // 比如音乐课他不需要先置的课程他就不会记录在prerequisites内
        int[] result = new int[numCourses];
        if (numCourses == 0)
            return result;

        if (prerequisites == null || prerequisites.length == 0) {
            // 没有一节课有先置课程
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        int[] indegree = new int[numCourses]; // 计算入度
        Queue<Integer> zeroDegree = new LinkedList<>();
        for (int[] pre : prerequisites)
            // 按照先置课程为起点到当前课程的一个指向，当前课程的入度+1
            // 也可以按照当前课程为起点，最后展现出来的图都是一样的，只是箭头方向不同
            indegree[pre[0]]++;

        for (int i = 0; i < indegree.length; i++) {
            // 计算入度为0的节点
            if (indegree[i] == 0)
                zeroDegree.add(i);
        }

        if (zeroDegree.isEmpty())
            return new int[0];

        int index = 0;
        while (!zeroDegree.isEmpty()) {
            int course = zeroDegree.poll(); // 取出队列中入度为0的节点
            result[index++] = course; // 学习当前课程
            for (int[] pre : prerequisites) {
                if (pre[1] == course) { // 以当前课程为先置课程的节点
                    indegree[pre[0]]--; // 入度减一
                    if (indegree[pre[0]] == 0) // 课程入度为0 时入队
                        zeroDegree.add(pre[0]);
                }
            }
        }

        for (int in : indegree) {
            if (in != 0) // 还有课程没学习完
                return new int[0];
        }

        return result;
    }

    // 拓扑排序2
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // [1,0] 0 -> 1
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // 当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses]; // 当前的前置课程学完后可以学的课程
        int[] counts = new int[numCourses]; // 计算入度
        int[] result = new int[numCourses];
        int idx = 0;
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) { // [1, 0] 0->1
            edges[prerequisite[1]].add(prerequisite[0]);
            counts[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (counts[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            result[idx] = remove;
            idx++;
            for (Integer child : edges[remove]) { // 查看当前可以学习的课程
                counts[child]--; // 学习子课程
                if (counts[child] == 0) {
                    queue.offer(child);
                }
            }
        }
        if (idx < numCourses) {
            result = new int[0];
        }
        return result;
    }
}
