package classical_150.java.heap;

import java.util.*;;

public class Solution373 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 }, nums2 = { 2, 4, 6 };
        Solution373 solution = new Solution373();
        System.out.println(solution.kSmallestPairs(nums1, nums2, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>(k); // 预分配空间
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); // 每次保证值较小的先被取出
        pq.add(new int[] { nums1[0] + nums2[0], 0, 0 }); // [值, nums1的下标, nums2的下标]

        while (!pq.isEmpty() && ans.size() < k) {
            int[] p = pq.poll();
            int i = p[1], j = p[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (j == 0 && i + 1 < n)
                pq.add(new int[] { nums1[i + 1] + nums2[0], i + 1, 0 });
            if (j + 1 < m)
                pq.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
        }

        // 问题：例如当 (1,0)出堆时，会把 (1,1) 入堆；
        // 当 (0,1)出堆时，也会把 (1,1) 入堆，这样堆中会有重复元素。
        // 为了避免有重复元素，还需要额外用一个哈希表记录在堆中的下标对。只有当下标对不在堆中时，才能入堆。

        return ans;
    }
}
