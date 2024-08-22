package leetcode_hot_100.binary;

public class Solution4 {
    // 寻找两个正序数组的中位数
    public static void main(String[] args) {
        int[] A = { 1, 4 };
        int[] B = { 2, 3, 5, 6 };
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(A, B));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int total = m + n;
        int mid = total / 2;

        if (total % 2 != 1) {
            return (getKth(nums1, nums2, mid) + getKth(nums1, nums2, mid + 1)) / 2.0;
        } else {
            return getKth(nums1, nums2, mid + 1);
        }

    }

    public int getKth(int[] A, int[] B, int k) {
        int n = A.length, m = B.length;
        int ai = 0, bi = 0;

        while (true) {
            if (ai == n) // A 的 已经全部被排除
                return B[bi + k - 1];
            if (bi == m) // B 的 已经全部被排除
                return A[ai + k - 1];
            if (k == 1)
                return Math.min(A[ai], B[bi]);

            int half = k / 2;
            int newAi = Math.min(ai + half, n) - 1; // 防止越界
            int newBi = Math.min(bi + half, m) - 1; // 防止越界

            if (A[newAi] <= B[newBi]) {
                k -= (newAi - ai + 1); // 去掉前 newAi - ai + 1 个数
                ai = newAi + 1;
            } else {
                k -= (newBi - bi + 1); // 去掉 newBi - bi + 1 个数
                bi = newBi + 1;
            }
        }
    }

}
